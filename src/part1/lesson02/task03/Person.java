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

    /**
     * @param quantityObjIntoArr - the desired size of an array filled with objects of the Person class.
     * @return - an array filled with objects of the Person class.
     */
    public static Person[] getPersonArray(int quantityObjIntoArr) {
        Person[] humans = new Person[quantityObjIntoArr];
//        humans[0] = new Person("Alex", Sex.getMAN(), 20); //This for test*
//        humans[1] = new Person("Alex", Sex.getMAN(), 20); //

        //Cycle generate  of a Person[quantityObjIntoArr]
//        for (int i = 2; i < quantityObjIntoArr; i++) {   //This for test*
        for (int i = 0; i < quantityObjIntoArr; i++) {
            int numCharsName = (int) ((10 * Math.random()) / 3 + (10 * Math.random()) / 3 + (10 * Math.random()) / 3) + 2;
            char[] chars = "zabcdefghijklmnopqrstuvwxyza".toCharArray();
            StringBuilder namePerson = new StringBuilder(numCharsName);

            // Cycle generate a Person the name
            for (int j = 0; j < numCharsName; j++) {
                char c = chars[(int) ((chars.length - 2) * Math.random() + 1)];
                if (j == 0) {
                    namePerson.append(String.valueOf(c).toUpperCase());
                }else namePerson.append(c);
            }

            // assigning a random gender
            String sex;
            int personSexInt = new Random().nextInt(40);
            if (personSexInt <= 10 | (personSexInt > 20 & personSexInt < 30)) sex = Sex.MAN;
            else sex = Sex.WOMAN;

            // assigning a random age
            int personAge = new Random().nextInt(90);

            humans[i] = new Person(namePerson.toString(), sex, personAge);
        }

        //The loop checks the array for clones
        for (int j = 0; j < quantityObjIntoArr; j++) {
            Person people = humans[j];
            for (int ex = 0; ex < quantityObjIntoArr; ex++) {
                if (ex == j) continue;
                if ((people.hashCode() == humans[ex].hashCode()) & people.equals(humans[ex]))
                    throw new MainErrExceptions("There is a clone in the array! || В массиве есть клон!\n");
            }
        }

        return humans;
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
