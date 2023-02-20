import java.util.*;
import static java.util.Collections.*;
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter n: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        Integer[] massiv = new Integer[size];
        System.out.print("Enter numbers through a space. Then Enter.");
        for (int i = 0; i < size; i++)
            massiv[i] = in.nextInt();
        List<Integer> listofMassiv = Arrays.asList(massiv);
        System.out.println("Max: " + max(listofMassiv));
        System.out.println("Min: " + min(listofMassiv));
        System.out.println("Divided into 3 or 9: " );
        for (int i = 0; i < size; i++) {
            if ((massiv[i] % 3 == 0) || (massiv[i] % 9 == 0))
                System.out.print(massiv[i] + " ");   }

    }
}