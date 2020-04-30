package part1.lesson02.task03;

import part1.lesson02.task01.MainErrExceptions;

import java.util.*;

/**
 * Create 23.04.2020
 *
 * @author Evtushenko Anton
 */

public class Person {
    // опять же будьте последовательны. Почему одно поле final, а два других нет - несправедливость :)
    private final String name;
    private final String sex;
    private final int age;

    // staticStringManOrWoman - суровое название аргумента :)
    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    /**
     * This method sorts an array of the Person class by Comparator
     *
     * @param people           - sortable array of the Person class
     * @param personComparator - comparator for sorting the Person class
     *
     * @return - sorted a Person[]
     */
    // статические методы - зло :) На самом деле нет ни одной хорошей причины, чтобы этот метод был здесь
    // он только перегружает класс Person
    public static Person[] sortByComparator(Person[] people, Comparator personComparator) {
        // хитро :) но речь шла о том, чтобы реализовать два разных метода сортировки по двум разным алгоритмам сортировки
        Set<Person> people1 = new TreeSet<>(personComparator);
        people1.addAll(Arrays.asList(people));

        // это не так работает :) в аргумент toArray нужно передавать массив
        return people1.toArray(new Person[people1.size()]);
    }

    /**
     * @param quantityObjIntoArr - the desired size of an array filled with objects of the Person class.
     * @return - an array filled with objects of the Person class.
     */
    public static Person[] getPersonArray(int quantityObjIntoArr) {
        // опять же - располагайте переменные как можно ближе к их использованию
        // randomOne - непонятное название для переменной

        Person[] humans = new Person[quantityObjIntoArr];
//        humans[0] = new Person("Alex", Sex.getMAN(), 20); //This for test*
//        humans[1] = new Person("Alex", Sex.getMAN(), 20); //

        //Cycle generate  of a Person[quantityObjIntoArr]
//        for (int i = 2; i < quantityObjIntoArr; i++) {   //This for test*
        for (int i = 0; i < quantityObjIntoArr; i++) {

            StringBuilder namePerson;
            int numCharsName = (int) ((10 * Math.random()) / 3 + (10 * Math.random()) / 3 + (10 * Math.random()) / 3) + 2;
            char[] chars = "zabcdefghijklmnopqrstuvwxyza".toCharArray();
            namePerson = new StringBuilder(numCharsName);

            // Cycle generate a Person the name
            for (int j = 0; j < numCharsName; j++) {
                char c = chars[(int) ((chars.length - 2) * Math.random() + 1)];
                if (j == 0) {
                    namePerson.append(String.valueOf(c).toUpperCase());
                }else namePerson.append(c);
            }

            // assigning a random gender
            String sex;
            Random random = new Random();
            int personSexInt = random.nextInt(40);
            if (personSexInt <= 10 | (personSexInt > 20 & personSexInt < 30)) sex = Sex.MAN;
            else sex = Sex.WOMAN;

            // assigning a random age
            int personAge;
            personAge = random.nextInt(90);

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
