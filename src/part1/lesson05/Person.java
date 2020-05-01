package part1.lesson05;

import java.util.Comparator;
import java.util.Objects;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Person implements Comparable {
    private final String name;
    private final Sex sex;
    private final int age;

    public Person(String name, Sex sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Person p1 = null;
        try {
            p1 = (Person) o;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
        return this.name.compareTo(p1.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name) &&
                sex == person.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }

    @Override
    public String toString() {
        return String.format("person \"%s\", age: %d, sex: %S.", name, age, sex);
    }

    public String getName() {
        return name;
    }
}
