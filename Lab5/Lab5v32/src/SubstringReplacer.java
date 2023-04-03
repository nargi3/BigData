import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SubstringReplacer {
    public static void main(String[] args) {
        // Check if the correct number of command-line arguments are provided
        if (args.length != 3) {
            System.out.println("Usage: java SubstringReplacer input_file output_file substring_replacement");
            System.exit(1);
        }

        // Parse the command-line arguments
        String inputFile = args[0];
        String outputFile = args[1];
        String replacement = args[2];
        String str;
        try {
            str = new String("улица".getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


        // Open the input file
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(inputFile), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file does not exist.");
            System.exit(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Open the output file
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(outputFile, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Output file cannot be created.");
            System.exit(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Read the input file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Replace the specified substring with the replacement string
            line = line.replace(str, replacement);

            // Write the modified line to the output file
            writer.println(line);
        }

        // Close the input and output files
        scanner.close();
        writer.close();
    }
}

// javac SubstringReplacer.java
// java SubstringReplacer input output_file ЗАМЕНА