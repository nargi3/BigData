import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String text = "cat dog dog hello hi. "
                + "print cat cat cat lock cat."
                + "hello bye dog.";
        String[] sentences = text.split("(?<=[.?!])\\s+");
        int maxSentencesWithIdenticalWords = 0;

        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");
            Set<String> uniqueWords = new HashSet<>();
            int numIdenticalWords = 0;

            for (String word : words) {
                if (!uniqueWords.add(word)) {
                    numIdenticalWords++;
                }
            }

            if (numIdenticalWords > 0 && numIdenticalWords > maxSentencesWithIdenticalWords) {
                maxSentencesWithIdenticalWords = numIdenticalWords;
            }
        }

        System.out.println("The largest number of sentences with identical words is: " + maxSentencesWithIdenticalWords);
    }
}