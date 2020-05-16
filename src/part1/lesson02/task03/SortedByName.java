package part1.lesson02.task03;

/**
 * Create 16.05.2020
 *
 * @autor Evtushenko Anton
 */

public class SortedByName implements Sorter{
    @Override
    public Person[] sorting(PersonStore store) {
        Person[] people = store.getPersons();

        int x = people.length;
        for (int i = 0; i < x; i++) {
            Person human = people[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                Person human2 = people[j];
                if (compare(human, human2) < 0) {
                    people[j + 1] = people[j];
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
        return a.getName().compareTo(b.getName());
    }
}
