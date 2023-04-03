import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

class MyException extends Exception {
    public MyException() {}
    public MyException(String msg) {
        super(msg);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer[] cust = new Customer[3];
        cust[0] = new Customer(1, "Anna;  ", "Petrova;  ", "Petrovna;  ", "Moscow;  ", 123, 56521);
        cust[1] = new Customer(2, "Boris;  ", "Artemyev;  ", "Alexandrovich;  ", "Zelenograd;  ", 321, 45545);
        cust[2] = new Customer(3, "Alexandr;  ", "Shirokov;  ", "Arsenyevich;  ", "Khimki;  ", 461, 12357);


        while (true) {

            System.out.println(
                    "Выберете пункт меню:\n"
                            + "1. вывод покупателей в алфавитном порядке\n"
                            + "2. вывод покупателей с кредитной картой в интервале\n"
                            + ": "
            );
            try {
                int choice;
                choice = scanner.nextInt();
                if (choice < 1 || choice > 2)
                    throw new InputMismatchException();


                if (choice == 0)
                    break;
                if (choice < 1 || choice > 2) {
                    System.out.println("выбран неправильный пункт меню, повторите ввод.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        Arrays.sort(cust, Comparator.comparing(Customer::getSurname));
                        for (int i = 0; i <= 2; i++) {
                            System.out.println(cust[i]);
                        }
                        break;
                    case 2:
                        long numto = 0, numfrom = 0;
                        System.out.println("Введите диапазон кредитных карт\n");
                        System.out.println("От: ");
                        int n1 = scanner.nextInt();
                        System.out.println("До: ");
                        int n2 = scanner.nextInt();
                        Customer.customer_check_credit_card(cust, n1, n2) ;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            } catch (InputMismatchException e) {
                System.out.println("Exception - " + e);
            }
        }
    }
}


