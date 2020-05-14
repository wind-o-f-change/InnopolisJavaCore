package part1.lesson05.comparators;

import part1.lesson05.enitities.Person;

import java.util.Comparator;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class SortByPerson implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = null;
        Person p2 = null;
        try {
            p1 = (Person) o1;
            p2 = (Person) o2;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
        return p1.getName().compareTo(p2.getName());
    }
}
