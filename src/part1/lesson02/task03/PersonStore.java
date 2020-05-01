package part1.lesson02.task03;

import java.util.*;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class PersonStore {
    private Person[] person;

    /**
     * This method sorts an array of the Person class by Comparator
     *
     * @param people           - sortable array of the Person class
     * @param personComparator - comparator for sorting the Person class
     *
     * @return - sorted a Person[]
     */
    public Person[] sortByComparator(Person[] people, Comparator personComparator) {
        // хитро :) но речь шла о том, чтобы реализовать два разных метода сортировки по двум разным алгоритмам сортировки
        Set<Person> people1 = new TreeSet<>(personComparator);
        people1.addAll(Arrays.asList(people));

        return people1.toArray(new Person[people1.size()]);
    }

    public PersonStore(){}

    public PersonStore(Person[] person) {
        this.person = person;
    }
}
