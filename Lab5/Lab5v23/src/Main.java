import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Patient[] pats = new Patient[3];
        pats[0] = new Patient(1, "Anna;  ", "Petrova;  ", "Petrovna;  ", "Moscow;  ", 798612312, 123, "Pain1");
        pats[1] = new Patient(2, "Boris;  ", "Artemyev;  ", "Alexandrovich;  ", "Zelenograd;  ", 798612312, 14, "Pain2");
        pats[2] = new Patient(3, "Alexandr;  ", "Shirokov;  ", "Arsenyevich;  ", "Khimki;  ", 798612312, 450, "Pain3");


        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n"
                            + "1. вывод пациентов с заданным диагнозом\n"
                            + "2. вывод пациентов с мед картой в интервале\n"
                            + ": "
            );
            try {
                int choice = scanner.nextInt();
                if (choice < 1 || choice > 2)
                    throw new InputMismatchException();
                if (choice == 0)
                    break;
                if (choice < 1 || choice > 3) {
                    System.out.println("выбран неправильный пункт меню, повторите ввод.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Введите диагноз для поиска пациентов: ");
                        String diagnosis = scanner.next();
                        Patient.check_diagnosis(pats, diagnosis);
                        break;
                    case 2:
                        long numto = 0, numfrom = 0;
                        System.out.println("Введите диапазон мед карт\n");
                        System.out.println("От: ");
                        int n1 = scanner.nextInt();
                        System.out.println("До: ");
                        int n2 = scanner.nextInt();
                        Patient.customer_check_med_card(pats, n1, n2);
                }
            } catch (InputMismatchException e) {
                System.out.println("Exception - " + e);
            }
        }
    }
}


