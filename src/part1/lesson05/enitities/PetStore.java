package part1.lesson05.enitities;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        Consumer<String> soutName = n -> System.out.println(String.format("\nfindByName(\"%s\")", n));
        soutName.accept(name);
        return findByNameMap.get(name);
    }

    public void changeByID(Pet pet) {
        long id = pet.getId();
        if (id < 0) throw new IllegalArgumentException("\"id\" питомца не может быть меньше нуля");

        boolean isFound = false;
        for (Set<Pet> v : findByNameMap.values()) {
            for (Pet pet1 : v) {
                if (id == pet1.getId()) {
                    isFound = true;
                    boolean validation = false;

                    boolean isWeight = false;
                    Predicate<Double> weightNotNull = w -> w > 0;
                    double weight = pet.getWeight();
                    Predicate<Double> weightNotEquals = w -> w != weight;
                    if (weightNotNull.test(weight) && weightNotEquals.test(pet1.getWeight())) {
                        pet1.setWeight(weight);
                        validation = true;
                        isWeight = true;
                    }

                    boolean isName = false;
                    Predicate<String> nameNotNull = Objects::nonNull;
                    String name = pet.getName();
                    Predicate<String> nameNotEquals = n -> !n.equals(name);
                    if (nameNotNull.test(name) && nameNotEquals.test(pet1.getName())) {
                        pet1.setName(name);
                        validation = true;
                        isName = true;
                    }

                    boolean isSex = false;
                    Predicate<Sex> sexNotNull = Objects::nonNull;
                    Sex sex = pet.getSex();
                    Predicate<Sex> sexEquals = s -> Objects.equals(s, sex);
                    if (sexNotNull.test(sex) && sexEquals.negate().test(pet1.getSex())) {
                        pet1.setSex(sex);
                        validation = true;
                        isSex = true;
                    }

                    boolean isPerson = false;
                    Predicate<Person> perNotNull = Objects::nonNull;
                    Person person = pet.getPerson();
                    Predicate<Person> perNotEquals = p -> !Objects.equals(person, p);
                    if (perNotNull.test(person) && perNotEquals.test(pet1.getPerson())) {
                        pet1.setPerson(person);
                        validation = true;
                        isPerson = true;
                    }

                    if (validation) {
                        StringBuilder sb = new StringBuilder("");
                        if (isWeight) sb.append(" \"Weight\"");
                        if (isName) sb.append(" \"Name\"");
                        if (isSex) sb.append(" \"Sex\"");
                        if (isPerson) sb.append(" \"Person\"");
                        System.out.println(String.format("\nИзменяемые параметры питомца \"%s\" успешно сохранены\nИзменены следующие параметры :%s", pet1.getName(), sb.toString()));
                        break;
                    } else throw new IllegalArgumentException("Поля для изменения не заданы");
                }
            }
        }
        if (!isFound) throw new IllegalArgumentException("Питомец не найден");
    }

    public void printPets() {
        System.out.println("\nprint Pets");
        findByNameMap.values().forEach(System.out::println);
    }

    public void printSortedPets(Comparator<Pet> byComparators) {
        Function<Comparator<Pet>, String> comparatorToString = petComparator -> petComparator.getClass().getSimpleName();

        Consumer<String> souter = petComparator -> System.out.println("\n" + petComparator);
        souter.accept(comparatorToString.apply(byComparators));

        List<Pet> pets = new ArrayList<>();
        findByNameMap.values().forEach(pets::addAll);

        pets.stream()
                .sorted(byComparators)
                .forEach(System.out::println);
    }

    public Map<String, Set<Pet>> getPets() {
        return findByNameMap;
    }
}