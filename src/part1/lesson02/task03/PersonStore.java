package part1.lesson02.task03;

import part1.lesson02.task01.MainErrExceptions;

import java.util.*;

/**
 * Create 01.05.2020
 *
 * @autor Evtushenko Anton
 */

public class PersonStore {
    private Person[] person;

    public Person[] getPersons() {
        return person;
    }

    /**
     * This method initializes the "person" array filled with objects of the Person class in the quantity specified into "quantityObjIntoArr".
     * @param quantityObjIntoArr - the desired size of an array filled with objects of the Person class.
     */
    public void readyPersonArr(int quantityObjIntoArr) {
        Person[] humans = new Person[quantityObjIntoArr];

        for (int i = 0; i < quantityObjIntoArr; i++) {
            int numCharsName = (int) ((10 * Math.random()) / 3 + (10 * Math.random()) / 3 + (10 * Math.random()) / 3) + 2;
            char[] chars = "zabcdefghijklmnopqrstuvwxyza".toCharArray();
            StringBuilder namePerson = new StringBuilder(numCharsName);

            // Cycle generate a Person the name
            for (int j = 0; j < numCharsName; j++) {
                char c = chars[(int) ((chars.length - 2) * Math.random() + 1)];
                if (j == 0) {
                    namePerson.append(String.valueOf(c).toUpperCase());
                }else namePerson.append(c);
            }

            // assigning a random gender
            String sex;
            int personSexInt = new Random().nextInt(40);
            if (personSexInt <= 10 | (personSexInt > 20 & personSexInt < 30)) sex = Sex.MAN;
            else sex = Sex.WOMAN;

            // assigning a random age
            int personAge = new Random().nextInt(90);

            humans[i] = new Person(namePerson.toString(), sex, personAge);
        }

        //The loop checks the array for clones
        for (int j = 0; j < quantityObjIntoArr; j++) {
            Person people = humans[j];
            for (int ex = 0; ex < quantityObjIntoArr; ex++) {
                if (ex == j) continue;
                if ((people.hashCode() == humans[ex].hashCode()) & people.equals(humans[ex]))
                    throw new MainErrExceptions("There is a clone in the array! || В массиве есть клон!\n");
            }
        }

        person = humans;
    }

    /**
     * @param sorter - comparator for sorting an array of the Person class.
     */
    public void runTask(Sorter sorter) {
        System.out.println(sorter.getClass().getSimpleName());
        Date startA = new Date();
        Arrays.asList(sorter.sorting(this)).forEach(System.out::println);
        Date endA = new Date();

        System.out.printf("\nВремя работы сортировщика составило %d мс.\n\n",
                (endA.getTime() - startA.getTime()));
    }

    public void runTask(Comparator sorter) {
        System.out.println(sorter.getClass().getSimpleName());
        Date startA = new Date();
        Arrays.sort(this.getPersons(), sorter);
        Arrays.asList(this.getPersons()).forEach(System.out::println);
        Date endA = new Date();

        System.out.printf("\nВремя работы сортировщика составило %d мс.\n\n",
                (endA.getTime() - startA.getTime()));
    }

    public PersonStore(int i){
        readyPersonArr(i);
    }

    public Person[] getPerson() {
        return person;
    }

    public void setPerson(Person[] person) {
        this.person = person;
    }
}
