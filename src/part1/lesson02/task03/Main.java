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

//         Сам алгоритм стал работать примерно в 2 раза быстрее :)
//        runTask(store, new SortedByName());
//        runTask(store.getPersons(), new SortedByName());
//         This for test
//        runTask(Person.getPersonArray(10001), new SortedByAge());
//        runTask(Person.getPersonArray(10001), new SortedByAge().thenComparing(new SortedByName());
//        runTask(Person.getPersonArray(10001), new SortedByName().thenComparing(new SortedByAge());
    }

    /**
     //     * @param personStore  - Store for a Person object.
     //     * @param c1 - comparator for sorting an array of the Person class.
     //     *
     //     * @throws MainErrExceptions
     //     */
    public static void runTask(PersonStore personStore, Sorter sorter) {
        Date startA = new Date();
        Arrays.asList(sorter.sorting(personStore)).forEach(System.out::println);
        Date endA = new Date();

        System.out.printf("\nВремя работы сортировщика составило %d мс.\n\n",
                (endA.getTime() - startA.getTime()));
    }

//    /**
//     * @param p  - array Person class.
//     * @param c1 - comparator for sorting an array of the Person class.
//     *
//     * @throws MainErrExceptions
//     */
//    public static void runTask(Person[] p, Comparator c1) {
//        Date startA = new Date();
//        Arrays.asList(new PersonStore().sortByComparator(p, c1)).forEach(System.out::println);
//        Date endA = new Date();
//
//        System.out.printf("\nВремя работы сортировщика составило %d мс.\n\n",
//                (endA.getTime() - startA.getTime()));
//    }
//
//    /**
//     * @param personStore  - Store for a Person object.
//     * @param c1 - comparator for sorting an array of the Person class.
//     *
//     * @throws MainErrExceptions
//     */
//    public static void runTask(PersonStore personStore, Comparator c1) {
//        Date startA = new Date();
//        Arrays.asList(personStore.sortByComparator(personStore.getPersons(), c1)).forEach(System.out::println);
//        Date endA = new Date();
//
//        System.out.printf("\nВремя работы сортировщика составило %d мс.\n\n",
//                (endA.getTime() - startA.getTime()));
//    }

    private Main(){}
}
