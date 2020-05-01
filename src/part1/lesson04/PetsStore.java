package part1.lesson04;

import java.util.HashMap;
import java.util.Map;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class PetsStore {
    private Map<String, Pet> petsMap = new HashMap<>();

    public void addPets(Pet pet) {
        System.out.println(petsMap.get(pet.getName()));
    }

    public PetsStore() {
    }

    public PetsStore(Map<String, Pet> petsMap) {
        this.petsMap = petsMap;
    }

    public Map<String, Pet> getPetsMap() {
        return petsMap;
    }


}
