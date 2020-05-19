package part1.lesson05.enitities;

import java.util.Objects;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Pet implements Comparable<Pet> {
    private static long settterID = 0;
    private final long id;
    private double weight;
    private String name;
    private Sex sex;
    private Person person;

    private Pet() {
        id = ++settterID;
    }

    public Pet(double weight, String name, Sex sex, Person person) {
        this();
        this.weight = weight;
        this.name = name;
        this.sex = sex;
        this.person = person;
    }

    public Pet(double weight, String name, Sex sex) {
        this();
        this.weight = weight;
        this.name = name;
        this.sex = sex;
    }

    public Pet(String name, Sex sex, Person person) {
        this();
        this.name = name;
        this.sex = sex;
        this.person = person;
    }

    public Pet(String name, double weight) {
        this();
        this.weight = weight;
        this.name = name;
    }

    public Pet(double weight, Sex sex) {
        this();
        this.weight = weight;
        this.sex = sex;
    }

    public Pet(double weight, Person person) {
        this();
        this.weight = weight;
        this.person = person;
    }

    public Pet(double weight) {
        this();
        this.weight = weight;
    }

    public Pet(String name, Sex sex) {
        this();
        this.name = name;
        this.sex = sex;
    }

    public Pet(String name, Person person) {
        this();
        this.name = name;
        this.person = person;
    }

    public Pet(String name) {
        this();
        this.name = name;
    }

    public Pet(Sex sex, Person person) {
        this();
        this.sex = sex;
        this.person = person;
    }

    public Pet(Sex sex) {
        this();
        this.sex = sex;
    }

    public Pet(Person person) {
        this();
        this.person = person;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id &&
                Double.compare(pet.weight, weight) == 0 &&
                Objects.equals(name, pet.name) &&
                sex == pet.sex &&
                Objects.equals(person, pet.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight, name, sex, person);
    }

    @Override
    public String toString() {
        return String.format("Pet \"%s\" \tID: %s,\tsex: %S,\tweight: %s.\t\tHis %s", name, id, sex, weight, person);
    }

    @Override
    public int compareTo(Pet p) {
        return Long.compare(this.id, p.id);
    }
}
