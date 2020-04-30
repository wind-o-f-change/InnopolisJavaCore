package part1.lesson02.task03;

import java.util.Comparator;

/**
 * Create 23.04.2020
 *
 * This class sorts instances of the Person class by sex
 *
 * @author Evtushenko Anton
 */

public class SortedByName implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Person a = (Person) o1;
        Person b = (Person) o2;

        return a.getName().compareTo(b.getName());
    }
}
