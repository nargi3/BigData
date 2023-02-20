public class Main {
    public static void main(String[] args) {
        System.out.println("Reverse arguments");
        for( int i = args.length - 1 ; i >= 0 ; i--)
        System.out.print(args[i] + " ");
    }
}