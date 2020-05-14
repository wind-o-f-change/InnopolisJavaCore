package part1.lesson05.comparators;

import part1.lesson05.enitities.Pet;

import java.util.Comparator;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class SortByWeight implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Pet p1 = (Pet) o1;
        Pet p2 = (Pet) o2;
        return Double.compare(p1.getWeight(), p2.getWeight());
    }
}
