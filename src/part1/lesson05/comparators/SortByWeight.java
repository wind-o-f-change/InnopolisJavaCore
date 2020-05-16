package part1.lesson05.comparators;

import part1.lesson05.enitities.Pet;

import java.util.Comparator;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class SortByWeight implements Comparator<Pet> {

    @Override
    public int compare(Pet o1, Pet o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}
