
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        int n = text.length();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                numbers[i] = c - 'a' + 1;
            }  else {
                numbers[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%2d  ", numbers[i]);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%2c  ", text.charAt(i));
        }
        System.out.println();
    }
}