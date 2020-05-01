package part1.lesson05;

import java.util.Objects;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Pet {
    private static long setterID = 0;
    private final long id;
    private final long weight;
    private final Sex sex;
    private final String name;
    private Person person;

    public Pet(String name, Sex sex, long weight, Person person) {
        this.id = ++setterID;
        this.weight = weight;
        this.sex = sex;
        this.person = person;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Person getPerson() {
        return person;
    }

    public long getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pets = (Pet) o;
        return id == pets.id &&
                weight == pets.weight &&
                sex == pets.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight, sex);
    }
}
