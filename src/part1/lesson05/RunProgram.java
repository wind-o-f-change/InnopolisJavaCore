package part1.lesson05;

import part1.lesson05.enitities.Person;
import part1.lesson05.enitities.Pet;
import part1.lesson05.enitities.PetStore;
import part1.lesson05.enitities.Sex;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class RunProgram {
    public static void main(String[] args) {
        PetStore petsStore = new PetStore();

        Person person11 = new Person("Igor", Sex.MAN, 56);
        Person person22 = new Person("Lena", Sex.WOMAN, 23);

        petsStore.addPet(new Pet("Dozor", Sex.MAN, 10, person11));
        petsStore.addPet(new Pet("Murka", Sex.WOMAN, 2.5, person22));
        petsStore.addPet(new Pet("Barsik", Sex.MAN, 4.0, person22));
        petsStore.addPet(new Pet("Murka", Sex.WOMAN, 2.0, person11));

        System.out.println("1");
        petsStore.findByName("Dozor").forEach(System.out::println);
        System.out.println("2");
        petsStore.findByName("Murka").forEach(System.out::println);

        System.out.println("3");
        petsStore.printPets();

        petsStore.changeByID(4, "Anfisa", 1.5, person22);

        System.out.println("4");
        petsStore.printPets();
    }
    private RunProgram(){}
}
