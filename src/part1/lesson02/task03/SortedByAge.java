package part1.lesson02.task03;

/**
 * Create 23.04.2020
 *
 * This class for sorts instances of the Person class by age
 *
 * @author Evtushenko Anton
 */

public class SortedByAge implements Sorter {
    /**
     * This method sorts a "Person" array by age from the "PersonStore" object
     * @param store the object stores a "Person" array
     * @return a "Person" array
     */
    // Insertion Sort
    @Override
    public Person[] sorting(PersonStore store) {
        Person[] people = store.getPersons();

        int x = people.length;
        for (int i = 0; i < x; i++) {
            Person human = people[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                Person human2 = people[j];
                if (compare(human, human2) > 0 ) {
                    people[j + 1] = human2;
                } else {
                    break;
                }
            }
            people[j + 1] = human;
        }
        return people;
    }

    @Override
    public int compare(Person a, Person b) {
        if (a.getAge() > b.getAge()) return -1;
        else if (a.getAge() < b.getAge()) return +1;
        else return 0;
    }
}