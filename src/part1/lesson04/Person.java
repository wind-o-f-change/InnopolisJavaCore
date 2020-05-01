package part1.lesson04;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Person {
    private final String name;
    private final Sex sex;
    private final int age;

    public Person(String name, Sex sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }



    @Override
    public String toString() {
        return String.format("Person name: %s, age: %d, sex: %S", name, age, sex) ;
    }
}
