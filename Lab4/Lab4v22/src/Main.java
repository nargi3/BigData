public class Main {

    /**
     * Вариант 2. Задача 2.
     * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов:
     * interface Абитуриент <- abstract class Студент <- class Студент-Заочник
     */

    public static void main(String[] args) {
        // Example of polymorphism
        Enrollee enrollee = new CorrStud();
        enrollee.sleep();

        // Example of inheritance
        Student student = new CorrStud();
        student.sleep();
        student.study();
    }
}

// Enrollee interface
interface Enrollee {
    void sleep();
}

// Student abstract class that implements Enrollee interface
abstract class Student implements Enrollee {
    public void sleep() {
        System.out.println("student is sleeping.");
    }

    // Abstract method for study
    abstract void study();
}

// CorrStud class that extends Student
class CorrStud extends Student {
    public void study() {
        System.out.println("correspondence student is studying.");
    }
}