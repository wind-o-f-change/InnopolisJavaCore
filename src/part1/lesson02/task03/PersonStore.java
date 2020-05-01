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

    /**
     * This method sorts an array of the Person class by Comparator
     *
     * @param people           - sortable array of the Person class
     * @param personComparator - comparator for sorting the Person class
     *
     * @return - sorted a Person[]
     */
    public Person[] sortByComparator(Person[] people, Comparator personComparator) {
        // хитро :) но речь шла о том, чтобы реализовать два разных метода сортировки по двум разным алгоритмам сортировки
        Set<Person> people1 = new TreeSet<>(personComparator);
        people1.addAll(Arrays.asList(people));

        return people1.toArray(new Person[people1.size()]);
    }

    public Person[] getPersons() {
        return person;
    }

    /**
     * @param quantityObjIntoArr - the desired size of an array filled with objects of the Person class.
     * @return - an array filled with objects of the Person class.
     */
    public Person[] createPersons(int quantityObjIntoArr){
        PersonStore store = new PersonStore();
        store.readyPersonArr(quantityObjIntoArr);
        return store.person;
    }
    /**
     * This method initializes the "person" array filled with objects of the Person class in the quantity specified into "quantityObjIntoArr".
     * @param quantityObjIntoArr - the desired size of an array filled with objects of the Person class.
     */
    public void readyPersonArr(int quantityObjIntoArr) {
        Person[] humans = new Person[quantityObjIntoArr];
//        humans[0] = new Person("Alex", Sex.getMAN(), 20); //This for test*
//        humans[1] = new Person("Alex", Sex.getMAN(), 20); //

        //Cycle generate  of a Person[quantityObjIntoArr]
//        for (int i = 2; i < quantityObjIntoArr; i++) {   //This for test*
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

    public PersonStore(){}

    public PersonStore(Person[] person) {
        this.person = person;
    }
}
