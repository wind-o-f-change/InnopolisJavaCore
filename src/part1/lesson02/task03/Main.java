package part1.lesson02.task03;

import java.util.Arrays;
import java.util.Date;

/**
 * Create 23.04.2020
 * This class for run tasks
 * @autor Evtushenko Anton
 */

public class Main {
    public static void main(String[] args) {
        PersonStore store = new PersonStore(10001);
        runTask(store, new SortedByAge());
        runTask(store, new SortedBySex());

    }

    /**
     * @param personStore  - Store for a Person object.
     * @param sorter - comparator for sorting an array of the Person class.
     */
    public static void runTask(PersonStore personStore, Sorter sorter) {
        Date startA = new Date();
        Arrays.asList(sorter.sorting(personStore)).forEach(System.out::println);
        Date endA = new Date();

        System.out.printf("\nВремя работы сортировщика составило %d мс.\n\n",
                (endA.getTime() - startA.getTime()));
    }

    private Main(){}
}
