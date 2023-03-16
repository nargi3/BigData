public class Main {

    /**
     * Вариант 2. Задача 3.
     * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов:
     * interface Сотрудник <- class Инженер <- class Руководитель.
     */

    public static void main(String[] args) {
        // Example of polymorphism
        Employee employee = new Supervisor();
        employee.sleep();

        // Example of inheritance
        Engineer engineer = new Supervisor();
        engineer.sleep();
        engineer.work();
    }
}

// Employee interface
interface Employee {
    void sleep();
}

// Engineer abstract class that implements Employee interface
abstract class Engineer implements Employee {
    public void sleep() {
        System.out.println("Engineer is sleeping.");
    }

    // Abstract method for work
    abstract void work();
}

// Supervisor class that extends Engineer
class Supervisor extends Engineer {
    public void work() {
        System.out.println("Supervisor is working.");
    }
}