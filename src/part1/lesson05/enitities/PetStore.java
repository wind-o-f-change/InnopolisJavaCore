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
        return findByNameMap.get(name);
    }

    public void changeByID(long id, Pet pet) {
        if (id < 0) throw new IllegalArgumentException("\"id\" питомца не может быть меньше нуля");

        for (Map.Entry<String, Set<Pet>> entry : findByNameMap.entrySet()) {
            String k = entry.getKey();
            Set<Pet> v = entry.getValue();
            for (Pet pet1 : v) {
                if (pet1.getId() == pet.getId()) {
                    Pet pet2 = pet1;
                    v.remove(pet1);
                    if (pet.getWeight() > 0)
                        pet2.setWeight(pet.getWeight());
                    if (pet.getName() != null)
                        pet2.setName(pet.getName());
                    if (pet.getPerson() != null)
                        pet2.setPerson(pet.getPerson());
                    if (pet.getSex() != null)
                        pet2.setSex(pet.getSex());
                    if (pet.getName() != null)
                        pet2.setPerson(pet.getPerson());
                    v.add(pet2);
                    System.out.println("Замена успешна");
                    break;
                }
            }
        }
    }

    public void printPets() {
        findByNameMap.forEach((k, v) -> v.forEach(System.out::println));
    }

    public void printSortedPets(Comparator<Pet> byComparators) {
        TreeSet<Pet> pets = new TreeSet<>(byComparators);
        findByNameMap.forEach((k, v) -> pets.addAll(v));
        pets.forEach(System.out::println);
    }

    public Map<String, Set<Pet>> getPets() {
        return findByNameMap;
    }
}