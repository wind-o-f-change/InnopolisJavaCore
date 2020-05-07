package part1.lesson02.task03;

/**
 * Create 23.04.2020
 *
 * This class for sorts instances of the Person class by sex
 *
 * @author Evtushenko Anton
 */

public class SortedBySex implements Sorter {
    /**
     * This method sorts a "Person" array by sex from the "PersonStore" object
     * @param store the object stores a "Person" array
     * @return a "Person" array
     */
    // Bubble Sort
    @Override
    public Person[] sorting(PersonStore store) {
        Person[] people = store.getPersons();

        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            int x = people.length;
            for (int i = 1; i < x; i++) {
                if (genderPoints(people[i]) > genderPoints(people[i -1])) {
                    swap(people, i, i-1);
                    needIteration = true;
                }
            }
        }
        return people;
    }

    private void swap(Person[] people, int ind1, int ind2) {
        Person person = people[ind1];
        people[ind1] = people[ind2];
        people[ind2] = person;
    }

    private int genderPoints(Person person) {
        int man = 1, woman = -1;
        if (person.getSex().equals("MAN")) return man;
        if (person.getSex().equals("WOMAN")) return woman;
        else throw new IllegalArgumentException("Указан недопустимый пол");
    }
}
