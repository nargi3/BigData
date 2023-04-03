import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Double> numbers = new HashSet<>();
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(4.0);
        numbers.add(5.0);
        while (numbers.size() > 1) {
            Set<Double> newNumbers = new HashSet<>();
            Double previous = null;
            for (Double number : numbers) {
                if (previous != null) {
                    //System.out.println(number);
                    newNumbers.add(previous + number);
                    //System.out.println(newNumbers);
                    previous = null;
                } else {
                    previous = number;
                }
            }
            if (previous != null) {
                newNumbers.add(previous);
            }
            numbers = newNumbers;
        }
        System.out.println("Result: " + numbers.iterator().next());
    }
}