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

        runTask(Person.getPersonArray(10001), persNameComp);
        runTask(Person.getPersonArray(10001), persAgeComp);
        runTask(Person.getPersonArray(10001), persCompAgeName);
        runTask(Person.getPersonArray(10001), persCompNameAge);
    }

    /**
     * @param p - array Person class.
     * @param c1 - comparator for sorting an array of the Person class.
     *
     * @throws MainErrExceptions
     */
    // если функция принимает больше 2-3 аргумента это повод задуматься о рефакторинге,
    // в нашем случае можно подумать о функции принимающей массив и конкретный Comparator
    public static void runTask(Person[] p, Comparator c1) {
        Date startA = new Date();
        Arrays.asList(Person.sortPersonArray(p, c1)).forEach(System.out::println);
        Date endA = new Date();

        System.out.printf("\nВремя работы сортировщика составило %d мс.\n\n",
                (endA.getTime() - startA.getTime()));
    }
    private Main(){}
}
