import java.util.Random;

public class Lab1v13 {
    public static void main(String[] args) {
        int n = 3;
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 3;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);

        System.out.println("Without transition");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < targetStringLength; j++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.toString();
            System.out.print(" " + generatedString);
            buffer.delete(0, buffer.length());
        }
        System.out.println();
        System.out.println("With transition");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < targetStringLength; j++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.toString();
            System.out.println(" " + generatedString);
            buffer.delete(0, buffer.length());
        }
    }


}