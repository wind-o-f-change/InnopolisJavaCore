package part1.lesson05.enitities;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public void changeByID(Pet pet) {
        long id = pet.getId();
        if (id < 0) throw new IllegalArgumentException("\"id\" питомца не может быть меньше нуля");

        boolean found = false;
        for (Set<Pet> v : findByNameMap.values()) {
            for (Pet pet1 : v) {
                if (id == pet1.getId()) {
                    found = true;
                    boolean validation = false;

                    try {
                        if (pet.getWeight() > 0 & (pet.getWeight() != pet1.getWeight())) {
                            pet1.setWeight(pet.getWeight());
                            validation = true;
                        }
                    } catch (NullPointerException e){
                    }

                    try {
                        if (pet.getName() != null & !pet.getName().equals(pet1.getName())) {
                            pet1.setName(pet.getName());
                            validation = true;
                        }
                    } catch (NullPointerException e){
                    }

                    try {
                        if (pet.getSex() != null & !pet.getSex().equals(pet1.getSex())) {
                            pet1.setSex(pet.getSex());
                            validation = true;
                        }
                    } catch (NullPointerException e){
                    }

                    try {
                        if (pet.getPerson() != null & !(Objects.equals(pet.getPerson(), pet1.getPerson()))) {
                            pet1.setPerson(pet.getPerson());
                            validation = true;
                        }
                    } catch (NullPointerException e){
                    }

                    if (validation) {
                        System.out.println(String.format("Изменяемые параметры питомца \"%s\" успешно сохранены", pet1.getName()));
                        break;
                    } else throw new IllegalArgumentException("Поля для изменения не заданы");
                }
            }
        }
        if (!found) throw new IllegalArgumentException("Питомец не найден");
    }

    public void printPets() {
        System.out.println("\nprint Pets");
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