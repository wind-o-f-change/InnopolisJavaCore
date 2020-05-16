package part1.lesson05.enitities;

import java.util.Objects;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Person implements Comparable<Person> {
    private String name;
    private Sex sex;
    private int age;

    public Person(String name, Sex sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                sex == person.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }

    @Override
    public String toString() {
        return String.format("person \"%s\",\tage: %d, sex: %S.", name, age, sex);
    }

    public String getName() {
        return name;
    }
}
