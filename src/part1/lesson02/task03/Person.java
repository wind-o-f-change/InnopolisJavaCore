package part1.lesson02.task03;

import part1.lesson02.task01.MainErrExceptions;

import java.util.*;

/**
 * Create 23.04.2020
 *
 * @author Evtushenko Anton
 */

public class Person {
    private final String name;
    private final String sex;
    private final int age;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return String.format("Person name is: %s, age= %d, sex:  %S", this.name, this.age, this.sex);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
