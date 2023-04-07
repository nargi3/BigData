import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String text = "cat dog print lock. "
                + "cat dog hello. "
                + "print dog light.";
        String[] sentences = text.split("(?<=[.?!])\\s+");
        String[] wordsInFirstSentence = sentences[0].split("\\s+");
        Set<String> uniqueWordsInFirstSentence = new HashSet<>(Arrays.asList(wordsInFirstSentence));
        Set<String> wordsInOtherSentences = new HashSet<>();

        for (int i = 1; i < sentences.length; i++) {
            String[] words = sentences[i].split("\\s+");
            wordsInOtherSentences.addAll(Arrays.asList(words));
        }

        uniqueWordsInFirstSentence.removeAll(wordsInOtherSentences);

        if (!uniqueWordsInFirstSentence.isEmpty()) {
            System.out.println("A word in the first sentence that is not present in any other sentence is: " + uniqueWordsInFirstSentence.iterator().next());
        } else {
            System.out.println("No unique words found in the first sentence.");
        }
    }
}