package part1.lesson02.task03;

import java.util.Comparator;

/**
 * Create 05.05.2020
 *
 * This interface for sorts instances of the Person class from the "PersonStore" object
 *
 * @autor Evtushenko Anton
 */

public interface Sorter extends Comparator<Person> {
    public Person[] sorting(PersonStore store);
}
