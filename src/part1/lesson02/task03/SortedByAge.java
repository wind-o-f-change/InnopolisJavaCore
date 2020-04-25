package part1.lesson02.task03;

import java.util.Comparator;

/**
 * Create 23.04.2020
 *
 * This class sorts instances of the Person class by age
 *
 * @author Evtushenko Anton
 */

public class SortedByAge implements Comparator {
    @Override
    public int compare(Object first, Object second) {
        Person a = (Person) first;
        Person b = (Person) second;

        if (a.getAge() > b.getAge()) return -1;
        else if (a.getAge() < b.getAge()) return +1;
        else return 0;
    }
}
