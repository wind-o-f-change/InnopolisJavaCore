package part1.lesson05;

import java.util.HashMap;
import java.util.Map;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class PetStore {
    private Map<String, Pet> petsMap = new HashMap<>();

    public void addPets(Pet pet) {
        if (petsMap.get(pet.getName()).isExists()){
            throw new ArrayStoreException(String.format("Pet with name %s exist already", pet.getName()));
        }
        petsMap.put(pet.getName(), pet);
    }

    public PetStore() {
    }

    public PetStore(Map<String, Pet> petsMap) {
        this.petsMap = petsMap;
    }

    public Map<String, Pet> getPetsMap() {
        return petsMap;
    }
}
