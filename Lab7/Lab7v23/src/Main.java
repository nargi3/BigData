import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String text = "In the text, find and print the 5 characters (and their number) that occur most often.";
        Map<Character, Integer> charFreq = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (charFreq.containsKey(c)) {
                charFreq.put(c, charFreq.get(c) + 1);
            } else {
                charFreq.put(c, 1);
            }
        }

        String top5Chars = charFreq.entrySet() //получение потока кодов символов (IntStream) из строки
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())  // сортировка (по убыванию количества вхождений)
                .limit(5) //ограничение количества результирующих записей
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.joining(", ")); //подсчет количества вхождений каждого символа

        System.out.println("Top 5 most frequently occurring characters: " + top5Chars);
    }
}