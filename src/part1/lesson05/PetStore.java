package part1.lesson05;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class PetStore {
    private Set<Pet> petSet = new HashSet<>();

    public void addPet(Pet pet) {
        if (petSet.contains(pet)) {
            throw new ArrayStoreException("It's pet exist already");
        }
        petSet.add(pet);
    }

    public PetStore() {
    }

    public Set<Pet> getPetSet() {
        return petSet;
    }

    public PetStore(Set<Pet> petSet) {
        this.petSet = petSet;
    }
}
