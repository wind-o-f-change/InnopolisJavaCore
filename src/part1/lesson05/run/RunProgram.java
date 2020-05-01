package part1.lesson05.run;

import part1.lesson05.Person;
import part1.lesson05.Pet;
import part1.lesson05.PetStore;
import part1.lesson05.Sex;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class RunProgram {
    public static void main(String[] args) {
        PetStore petStore = new PetStore();
        Person p1 = new Person("Ada", Sex.WOMAN, 34);
        Pet pet = new Pet("Murka",Sex.WOMAN, 2.4, p1);
        System.out.println(pet);
//        petStore.addPet(pet);
//        petStore.addPet(pet);
    }
    private RunProgram(){}
}
