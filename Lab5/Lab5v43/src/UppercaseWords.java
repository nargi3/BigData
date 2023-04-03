import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UppercaseWords {
    public static void main(String[] args) {
        String inputFilename = args[0];
        String outputFilename = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // split the line into words
                for (String word : words) {
                    if (word.length() > 2) { // check if the word is longer than two characters
                        String uppercaseWord = word.toUpperCase(); // convert the word to uppercase
                        writer.write(uppercaseWord);
                    } else {
                        writer.write(word);
                    }
                    writer.write(" ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}