package part1.lesson05;

import part1.lesson05.comparators.SortByName;
import part1.lesson05.comparators.SortByPerson;
import part1.lesson05.comparators.SortByWeight;
import part1.lesson05.enitities.Person;
import part1.lesson05.enitities.Pet;
import part1.lesson05.enitities.PetStore;
import part1.lesson05.enitities.Sex;

import java.util.UUID;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class RunProgram {
    public static void main(String[] args) {
        PetStore petsStore = new PetStore();

        Pet pet1 = new Pet("Dozor", Sex.MAN, 10, new Person("Igor", Sex.MAN, 56));
        petsStore.addPet(pet1);

        Pet pet2 = new Pet("Murka", Sex.WOMAN, 2.5, new Person("Lena", Sex.WOMAN, 23));
        petsStore.addPet(pet2);

        Pet pet3 = new Pet("Murka", Sex.WOMAN, 2.0, new Person("Lara", Sex.WOMAN, 12));
        petsStore.addPet(pet3);

        Pet pet4 = new Pet("Barsik", Sex.MAN, 4.0, new Person("Anton", Sex.MAN, 5));
        petsStore.addPet(pet4);

        petsStore.findByName("Dozor").forEach(System.out::println);
        petsStore.findByName("Murka").forEach(System.out::println);

        petsStore.printPets();

        petsStore.changeByID(new Pet(2L, "Anfisa"));
        petsStore.changeByID(new Pet(3L, new Person("Zhizh", Sex.MAN, 135)));

        petsStore.printPets();

        petsStore.printSortedPets(new SortByName());
        petsStore.printSortedPets(new SortByWeight());
        petsStore.printSortedPets(new SortByPerson());

        petsStore.changeByID(pet4);    // Поля для изменения не заданы
        petsStore.changeByID(new Pet(0.0002)); // Питомец не найден
    }

    private RunProgram() {
    }
}
