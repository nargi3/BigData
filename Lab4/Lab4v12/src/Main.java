

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Вариант 1. Задача 2.
     * Создать класс CD (mp3-диск) с внутренним классом, с помощью объектов
     * которого можно хранить информацию о каталогах, подкаталогах и записях.
     */

    public static void main(String[] args) {
        CD cd = new CD("MP3-disk");
        cd.addCatalog("Catalog1");
        cd.addCatalog("Catalog2");
        cd.addCatalog("Catalog2");

        CD.Department catalog1 = cd.getDepartment("Catalog1");
        catalog1.addSubDir("Subdirectory11", "property 11");
        catalog1.addSubDir("Subdirectory12", "property 12");

        CD.Department catalog2 = cd.getDepartment("Catalog2");
        catalog2.addSubDir("Subdirectory21", "property 21");
        catalog2.addSubDir("Subdirectory22", "property 22");

        System.out.println("Welcome to "+cd.getName()+"!");
        System.out.println("Subdirectories in Catalog1:");
        for (CD.Department.Prop prop : catalog1.getProps()) {
            System.out.println(prop.getName() + " - " + prop.getProperty());
        }

        System.out.println("\nSubdirectories in Catalog2:");
        for (CD.Department.Prop prop : catalog2.getProps()) {
            System.out.println(prop.getName() + " - " + prop.getProperty());
        }
    }
}

class CD {

    private String name;
    private List<Department> departments;

    public CD(String name) {
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