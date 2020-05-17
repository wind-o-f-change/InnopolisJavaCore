package part1.lesson05.enitities;

import java.util.*;

/**
 * Create 01.05.2020
 * <p>
 * This class is store objects of the <Pet>class
 *
 * @autor Evtushenko Anton
 */

public class PetStore {
    private Map<String, Set<Pet>> findByNameMap = new HashMap<>();

    public void addPet(Pet pet) {
        String name = pet.getName();
        if (!findByNameMap.containsKey(name)) {
            Set<Pet> pets = new HashSet<>();
            pets.add(pet);
            findByNameMap.put(name, pets);
        } else {
            findByNameMap.get(name).add(pet);
        }
    }

    public Set<Pet> findByName(String name) {
        System.out.println(String.format("\nfindByName(\"%s\")", name));
        return findByNameMap.get(name);
    }

    public void changeByID(long id, Pet pet) {
        if (id < 0) throw new IllegalArgumentException("\"id\" питомца не может быть меньше нуля");

        findByNameMap.forEach((k, v) -> {
            for (Pet pet1 : v)
                if (id == pet1.getId()) {
                    if (pet.getWeight() > 0)
                        pet1.setWeight(pet.getWeight());
                    if (pet.getName() != null)
                        pet1.setName(pet.getName());
                    if (pet.getSex() != null)
                        pet1.setSex(pet.getSex());
                    if (pet.getPerson() != null)
                        pet1.setPerson(pet.getPerson());
                    break;
                }
        });
    }

    public void printPets() {
        System.out.println("\nprint Pets changed");
        findByNameMap.forEach((k, v) -> v.forEach(System.out::println));
    }

    public void printSortedPets(Comparator<Pet> byComparators) {
        System.out.println("\n" + byComparators.getClass().getSimpleName());
        TreeSet<Pet> pets = new TreeSet<>(byComparators);
        findByNameMap.forEach((k, v) -> pets.addAll(v));
        pets.forEach(System.out::println);
    }

    public Map<String, Set<Pet>> getPets() {
        return findByNameMap;
    }
}