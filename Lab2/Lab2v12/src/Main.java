import java.util.Date;
import java.util.Scanner;
public class Main {
    static String fio;
    static int days;
    static Date BeginTaskDate() {
        Date beginDate = new Date();
        beginDate.getDate();
        System.out.println("Date of begin " + beginDate);
        return beginDate;
    }

    static Date FinishTaskDate() {
        Date finishDate = new Date();
        Long time = finishDate.getTime();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of days ");
        days = Integer.parseInt(in.nextLine());

        time = time + (60 * 60 * 24 * 1000 * days);
        finishDate = new Date(time);
        System.out.println("Date Of Finish Task = " + finishDate);
        return finishDate;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of rows:");
        Scanner secin = new Scanner(System.in);
        int rows = Integer.parseInt(secin.nextLine());
        String min = null;
        String max = null;
        String[] strings = new String[rows];
        String[] strings2 = new String[rows];
        float average = 0;
        for (int i = 0; i < rows; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your FIO ");
            strings[i] = in.nextLine();
            strings2[i] = strings[i];

            average = average + strings[i].length(); //сумма длин строк

            System.out.println("Your FIO is " + strings[i]);

            BeginTaskDate();
            FinishTaskDate();
        }

        for (int i = rows-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (strings[j].length() > strings[j + 1].length()) {
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
                if (strings2[j].length() < strings2[j + 1].length()) {
                    String temp = strings2[j];
                    strings2[j] = strings2[j + 1];
                    strings2[j + 1] = temp;
                }
            }
        }
        System.out.println("Increase:  "); //возрастание
        for (int i = 0; i < rows; i++) {
            System.out.println(strings[i] + " ");
        }
        System.out.println("Descending: "); //убывание
        for (int i = 0; i < rows; i++) {
            System.out.println(strings2[i] + " ");
        }


        // Ex 3
        average = average / rows; //среднее арифметическое суммы длин этих строк
        System.out.println("Average length: " + average);
        System.out.println("More than average: ");
        for (int j = 0; j < rows; j++) {
            if (strings[j].length() > average) {
                System.out.println(strings[j] + " length: " + strings[j].length());
            }
        }
        System.out.println("Less than average: ");
        for (int j = 0; j < rows; j++) {
            if (strings[j].length() < average) {
                System.out.println(strings[j] + " length: " + strings[j].length());
            }
        }
    }

}
