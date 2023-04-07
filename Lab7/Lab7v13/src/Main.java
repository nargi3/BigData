public class Main {
    public static void main(String[] args) {
        String text = "PAJKJ P A PPIHJH PAA";
        String correctedText = text.replaceAll("(?<=P)A(?=\\p{L})", "O");
        System.out.println(correctedText);
    }
}