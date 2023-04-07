import java.util.Random;

public class Store {
    private int inventory = 0;

    public synchronized void addInventory(int quantity) {
        inventory += quantity;
        System.out.println("Manufacturer delivered " + quantity + " products to the store. Total inventory: " + inventory);
        notifyAll();
    }

    public synchronized void sellInventory(int quantity) {
        while (inventory < quantity) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted while waiting for inventory");
            }
        }
        inventory -= quantity;
        System.out.println("Buyer purchased " + quantity + " products from the store. Total inventory: " + inventory);
    }

    public static void main(String[] args) {
        Store store = new Store();

        Thread manufacturerThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(5000) + 1000); // Simulate buyer arrival time
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int quantity = random.nextInt(10) + 1; // Random number of products delivered
                store.addInventory(quantity);
            }
        });

        Thread buyerThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(5000) + 1000); // Simulate buyer arrival time
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int quantity = random.nextInt(10) + 1; // Random number of products to buy
                store.sellInventory(quantity);
            }
        });

        manufacturerThread.start();
        buyerThread.start();
    }
}