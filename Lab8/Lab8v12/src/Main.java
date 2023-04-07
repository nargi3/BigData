public class Main {
    public static void main(String[] args) {
        Thread leftLeg = new Thread(new Leg("LEFT"));
        Thread rightLeg = new Thread(new Leg("RIGHT"));

        leftLeg.start();
        rightLeg.start();
    }

    private static class Leg implements Runnable {
        private final String name;

        public Leg(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}