import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "apbanana", "apricot", "apavocado");
        String template = "ap";
        String firstElement = strings.stream()
                .findFirst()
                .orElse(null);
        boolean allMatch = strings.stream()
                .allMatch(string -> string.startsWith(template));
        System.out.println("First element: " + firstElement);
        System.out.println("All match with template: " + allMatch);
    }
}