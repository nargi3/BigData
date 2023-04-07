import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "What a good day I'm having today!\n" +
                "A good day to be free.";
        List<String> words = Arrays.asList("day", "good", "be", "What");

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, 0);
        }

        String[] sentences = text.split("[.?!]\\s*");
        for (String sentence : sentences) {
            String[] sentenceWords = sentence.split("\\s+");
            for (String word : sentenceWords) {
                if (frequencyMap.containsKey(word)) {
                    frequencyMap.put(word, frequencyMap.get(word) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}