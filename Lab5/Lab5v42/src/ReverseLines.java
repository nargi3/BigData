import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseLines {
    public static void main(String[] args) {
        String inputFilename = args[0];
        String outputFilename = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder reversedLine = new StringBuilder(line).reverse(); // reverse the line
                writer.write(reversedLine.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}