import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ArrayList<Double> I = new ArrayList<>(Arrays.asList(1.2, 2.4, 4.8, 5.6, 6.4)); // current measurements
        ArrayList<Double> U = new ArrayList<>(Arrays.asList(2.4, 4.8, 9.6, 11.2, 12.8)); // voltage measurements
        int n = I.size();
        double sumI = I.stream().mapToDouble(Double::doubleValue).sum();
        double sumU = U.stream().mapToDouble(Double::doubleValue).sum();
        double sumIU = 0;
        double sumI2 = 0;
        for (int i = 0; i < n; i++) {
            sumIU += I.get(i) * U.get(i);
            sumI2 += Math.pow(I.get(i), 2);
        }
        double R = (n * sumIU - sumI * sumU) / (n * sumI2 - Math.pow(sumI, 2));
        System.out.println("Approximate value of resistance R: " + R);
    }
}