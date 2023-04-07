import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<People> peoples = Arrays.asList(
                new People("Ivan", 27),
                new People("Petr", 23),
                new People("Maria", 42)
        );

        List<People> sortedPeoples = peoples.stream()
                .sorted(Comparator.comparing(People::getAge))
                .collect(Collectors.toList());

        System.out.println("Sorted peoples: " + sortedPeoples);
    }
}

class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}