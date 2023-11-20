import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Person {
    String name;
    int level;

    public Person(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}

public class main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(List.of(
                new Person("a", 3),
                new Person("b", 10),
                new Person("c", 2),
                new Person("d", 4),
                new Person("e", 4),
                new Person("f", 4)
        ));

        Optional<Person> personWithHighestLevel = persons
                .stream()
                .max(Comparator.comparingInt(p -> p.level));



        System.out.println(personWithHighestLevel);
    }
}
