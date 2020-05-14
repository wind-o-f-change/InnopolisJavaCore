package part1.lesson05;

import part1.lesson05.comparators.SortByName;
import part1.lesson05.comparators.SortByPerson;
import part1.lesson05.comparators.SortByWeight;
import part1.lesson05.enitities.Person;
import part1.lesson05.enitities.Pet;
import part1.lesson05.enitities.PetStore;
import part1.lesson05.enitities.Sex;

import java.util.TreeSet;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class RunProgram {
    public static void main(String[] args) {
        PetStore petsStore = new PetStore();

        petsStore.addPet(new Pet("Dozor", Sex.MAN, 10,
                new Person("Igor", Sex.MAN, 56)));

        petsStore.addPet(new Pet("Murka", Sex.WOMAN, 2.5,
                new Person("Lena", Sex.WOMAN, 23)));

        petsStore.addPet(new Pet("Barsik", Sex.MAN, 4.0,
                new Person("Ivan", Sex.MAN, 5)));

        petsStore.addPet(new Pet("Murka", Sex.WOMAN, 2.0,
                new Person("Lara", Sex.WOMAN, 12)));

        System.out.println("\nfindByName(\"Dozor\")");
        petsStore.findByName("Dozor").forEach(System.out::println);
        System.out.println("\nfindByName(\"Murka\")");
        petsStore.findByName("Murka").forEach(System.out::println);

        System.out.println("\nprintPets");
        petsStore.printPets();

        petsStore.changeByID(4, "Anfisa", 1.5);

        System.out.println("\nprint Pets changed");
        petsStore.printPets();

        System.out.println("\nSortByName");
        petsStore.printSortedPets(new SortByName());
        System.out.println("\nSortByWeight");
        petsStore.printSortedPets(new SortByWeight());
        System.out.println("\nSortByPerson");
        petsStore.printSortedPets(new SortByPerson());
        System.out.println("\nSortBy: Person/Name/Weight");
        petsStore.printSortedPets(new SortByPerson().thenComparing(new SortByName().thenComparing(new SortByWeight())));
        System.out.println("\nSortBy: Weight/Person/Name");
        petsStore.printSortedPets(new SortByWeight().thenComparing(new SortByPerson().thenComparing(new SortByName())));
    }
    private RunProgram(){}
}
