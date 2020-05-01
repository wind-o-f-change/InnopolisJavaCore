package part1.lesson02.task03;

import part1.lesson02.task01.MainErrExceptions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * Create 23.04.2020
 * This class for run tasks
 * @autor Evtushenko Anton
 */

public class Main {
    public static void main(String[] args) {
        PersonStore store = new PersonStore(Person.getPersonArray(10001));
        runTask(store, new SortedByName());
        runTask(store.getPersons(), new SortedByName());

        // This for test
//        runTask(Person.getPersonArray(10001), new SortedByAge());
//        runTask(Person.getPersonArray(10001), new SortedByAge().thenComparing(new SortedByName());
//        runTask(Person.getPersonArray(10001), new SortedByName().thenComparing(new SortedByAge());
    }

    /**
     * @param p  - array Person class.
     * @param c1 - comparator for sorting an array of the Person class.
     *
     * @throws MainErrExceptions
     */
    public static void runTask(Person[] p, Comparator c1) {
        Date startA = new Date();
        Arrays.asList(new PersonStore().sortByComparator(p, c1)).forEach(System.out::println);
        Date endA = new Date();

        System.out.printf("\nВремя работы сортировщика составило %d мс.\n\n",
                (endA.getTime() - startA.getTime()));
    }

    public static void runTask(PersonStore personStore, Comparator c1) {
        Date startA = new Date();
        Arrays.asList(personStore.sortByComparator(personStore.getPersons(), c1)).forEach(System.out::println);
        Date endA = new Date();

        System.out.printf("\nВремя работы сортировщика составило %d мс.\n\n",
                (endA.getTime() - startA.getTime()));
    }

    private Main(){}
}
