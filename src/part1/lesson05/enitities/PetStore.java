package part1.lesson05.enitities;

import java.util.*;

/**
 * Create 01.05.2020
 *
 * This class is store objects of the <Pet>class
 *
 * @autor Evtushenko Anton
 */

public class PetStore {
    private TreeSet<Pet> sortByIDSet = new TreeSet<>();
    private Map<String, Set<Pet>> findByNameMap = new HashMap<>();

    public void addPet(Pet pet) {
        String name = pet.getName();

        if (!sortByIDSet.contains(pet)) {
            sortByIDSet.add(pet);

            if (!findByNameMap.containsKey(name)) {
                Set<Pet> pets = new HashSet<>();
                pets.add(pet);
                findByNameMap.put(name, pets);
            } else {
                findByNameMap.get(name).add(pet);
            }
        }
    }

    public Set<Pet> findByName(String name) {
        // Start
        return findByNameMap.get(name);
    }

    public void changeByID(int id, String name, double weight, Person person) {
        if (id < 1) throw new IllegalArgumentException("\"id\" питомца не может быть ноль");

        Pet[] pets = new Pet[sortByIDSet.size()];
        sortByIDSet.toArray(pets);

        Pet p = pets[id - 1];
        p.setName(name);
        p.setWeight(weight);
        p.setPerson(person);
        pets[id - 1] = p;
        sortByIDSet.clear();
        sortByIDSet.addAll(Arrays.asList(pets));
    }

    public void printPets() {
        sortByIDSet.forEach(System.out::println);
    }
}