

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Вариант 1. Задача 3.
     * Создать класс Mobile с внутренним классом,
     * с помощью объектов которого можно хранить информацию о моделях телефонов и их свойствах.
     */

    public static void main(String[] args) {
        Mobile mobile = new Mobile("Mobile");
        mobile.addCatalog("Model 1");
        mobile.addCatalog("Model 2");

        Mobile.Department model1 = mobile.getDepartment("Model 1");
        model1.addSubDir("Telephon11", "property 11");
        model1.addSubDir("Telephon12", "property 12");

        Mobile.Department model2 = mobile.getDepartment("Model 2");
        model2.addSubDir("Telephon21", "property 21");
        model2.addSubDir("Telephon22", "property 22");

        System.out.println("Welcome to "+mobile.getName()+"!");
        System.out.println("Telephons in model1:");
        for (Mobile.Department.Prop prop : model1.getProps()) {
            System.out.println(prop.getName() + " - " + prop.getProperty());
        }

        System.out.println("\nTelephons in model2:");
        for (Mobile.Department.Prop prop : model2.getProps()) {
            System.out.println(prop.getName() + " - " + prop.getProperty());
        }
    }
}

class Mobile {

    private String name;
    private List<Department> departments;

    public Mobile(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCatalog(String name) {
        Department department = new Department(name);
        departments.add(department);
    }

    public Department getDepartment(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    public class Department {
        private String name;
        private List<Prop> props;

        public Department(String name) {
            this.name = name;
            this.props = new ArrayList<>();
        }

        public void addSubDir(String name, String property) {
            Prop prop = new Prop(name, property);
            props.add(prop);
        }

        public Prop getProp(String name) {
            for (Prop prop : props) {
                if (prop.getName().equals(name)) {
                    return prop;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }

        public List<Prop> getProps() {
            return props;
        }

        public class Prop {
            private String name;
            private String property;

            public Prop(String name, String property) {
                this.name = name;
                this.property = property;
            }

            public String getName() {
                return name;
            }

            public String getProperty() {
                return property;
            }
        }
    }
}