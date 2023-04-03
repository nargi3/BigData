import java.util.Arrays;

class ParkingLot {
    private boolean[] spaces;

    public ParkingLot(int n) {
        spaces = new boolean[n];
        Arrays.fill(spaces, false);
    }

    public int park() {
        for (int i = 0; i < spaces.length; i++) {
            if (!spaces[i]) {
                spaces[i] = true;
                return i;
            }
        }
        return -1;
    }

    public boolean leave(int spot) {
        if (spot >= 0 && spot < spaces.length && spaces[spot]) {
            spaces[spot] = false;
            return true;
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        // create a parking lot with 5 spaces
        ParkingLot lot = new ParkingLot(5);

        // park 3 cars
        int spot1 = lot.park();
        int spot2 = lot.park();
        int spot3 = lot.park();

        // try to park another car (should fail)
        int spot4 = lot.park();

        if (spot1 >= 0) {
            System.out.println("Car parked in spot " + spot1);
        }
        if (spot2 >= 0) {
            System.out.println("Car parked in spot " + spot2);
        }
        if (spot3 >= 0) {
            System.out.println("Car parked in spot " + spot3);
        }
        if (spot4 >= 0) {
            System.out.println("Car parked in spot " + spot4);
        } else {
            System.out.println("Parking lot is full");
        }

        // vacate the first parking space
        boolean success = lot.leave(spot1);

        if (success) {
            System.out.println("Car left spot " + spot1);
        } else {
            System.out.println("Spot " + spot1 + " is already empty or out of range");
        }

        // park another car in the first parking space
        int spot5 = lot.park();

        if (spot5 >= 0) {
            System.out.println("Car parked in spot " + spot5);
        } else {
            System.out.println("Parking lot is full");
        }
    }
}