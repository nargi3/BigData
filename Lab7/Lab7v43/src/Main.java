import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "letters in for aim accuracy file them";
        String[] words = text.split("\\s+");

        Arrays.sort(words, (a, b) -> {
            int lengthCompare = Integer.compare(b.length(), a.length());
            if (lengthCompare != 0) {
                return lengthCompare;
            } else {
                int vowelCompare = Integer.compare(countVowels(a), countVowels(b));
                return vowelCompare;
            }
        });

        for (String word : words) {
            System.out.println(word);
        }
    }

    private static int countVowels(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}