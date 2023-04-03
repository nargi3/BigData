import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VowelWords {
    public static void main(String[] args) {
        String inputFilename = args[0];
        String outputFilename = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // split the line into words
                for (String word : words) {
                    if (word.matches("[AEIOUaeiou].*")) { // check if the word starts with a vowel
                        writer.write(word);
                        writer.write(" ");
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}