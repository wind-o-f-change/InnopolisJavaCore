package part1.lesson02.task03;

import part1.lesson02.task01.MainErrExceptions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * Create 23.04.2020
 *
 * @autor Evtushenko Anton
 */

public class Main {
    public static void main(String[] args) {

        Comparator persNameComp= new SortedByName();
        Comparator persAgeComp = new SortedByAge();
        Comparator persCompAgeName = new SortedByAge().thenComparing(new SortedByName());
        Comparator persCompNameAge = new SortedByName().thenComparing(new SortedByAge());

        Person[] people = Person.getPersonArray(10001);
        runTask(people, persNameComp, persAgeComp, persCompAgeName, persCompNameAge);
    }

    /**
     *
     * @param p - array Person class.
     * @param c1 - comparator for sorting an array of the Person class.
     * @param c2 - comparator for sorting an array of the Person class.
     * @param c3 - comparator for sorting an array of the Person class.
     * @param c4 - comparator for sorting an array of the Person class.
     * @throws MainErrExceptions
     */
    public static void runTask(Person[] p, Comparator c1, Comparator c2, Comparator c3, Comparator c4) {

        Date startA = new Date();
        Arrays.asList(Person.sortPersonArray(p, c2)).forEach(System.out::println);
        Date endA = new Date();

        Date startN = new Date();
        Arrays.asList(Person.sortPersonArray(p, c1)).forEach(System.out::println);
        Date endN = new Date();

        Date startAN = new Date();
        Arrays.asList(Person.sortPersonArray(p, c3)).forEach(System.out::println);
        Date endAN = new Date();

        Date startNA = new Date();
        Arrays.asList(Person.sortPersonArray(p, c4)).forEach(System.out::println);
        Date endNA = new Date();

        System.out.printf("Время работы сортировщика №1 составило %d мс.\n",
                (endA.getTime() - startA.getTime()));
        System.out.printf("Время работы сортировщика №2 составило %d мс.\n",
                (endN.getTime() - startN.getTime()));
        System.out.printf("Время работы сортировщика №3 составило %d мс.\n",
                (endAN.getTime() - startAN.getTime()));
        System.out.printf("Время работы сортировщика №4 составило %d мс.\n",
                 (endNA.getTime() - startNA.getTime()));
    }
}
