package part1.lesson05.comparators;

import part1.lesson05.enitities.Person;
import part1.lesson05.enitities.Pet;

import java.util.Comparator;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class SortByPerson implements Comparator<Pet> {

    @Override
    public int compare(Pet p1, Pet p2) {
        return p1.getPerson().compareTo(p2.getPerson());
    }
}
