package part1.lesson05.enitities;

import java.util.Objects;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Pet implements Comparable{
    private static int setterID = 0;
    private final int id;
    private double weight;
    private String name;
    private final Sex sex;
    private Person person;

    public Pet(String name, Sex sex, double weight, Person person) {
        this.id = ++setterID;
        this.weight = weight;
        this.sex = sex;
        this.person = person;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        return Objects.hash(id, sex);
    }

    @Override
    public String toString() {
        return String.format("Pet \"%s\", ID: %d, sex: %S, weight: %s.\tHis %s", name, id, sex, weight, person);
    }

    @Override
    public int compareTo(Object o) {
        Pet p = (Pet) o;
        return Integer.compare(this.id, p.id);
    }
}
