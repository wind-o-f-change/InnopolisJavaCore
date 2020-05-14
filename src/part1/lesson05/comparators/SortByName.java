package part1.lesson05.comparators;

import part1.lesson05.enitities.Pet;

import java.util.Comparator;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class SortByName implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Pet p1 = null;
        Pet p2 = null;
        try {
            p1 = (Pet) o1;
            p2 = (Pet) o2;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
        return p1.getName().compareTo(p2.getName());
    }
}
