package part1.lesson02.task03;

/**
 * Create 23.04.2020
 *
 * This class sorts instances of the Person class by age
 *
 * @author Evtushenko Anton
 */

public class SortedByAge implements Sorter {
    @Override
    public Person[] sorting(PersonStore store) {
        Person[] people = store.getPersons();

        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            int x = people.length;
            for (int i = 1; i < x; i++) {
                if (people[i].getAge() > people[i - 1].getAge()) {
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
//    implements Comparator
//    @Override
//    public int compare(Object first, Object second) {
//        Person a = (Person) first;
//        Person b = (Person) second;
//
////        if (a.getAge() > b.getAge()) return -1;
////        else if (a.getAge() < b.getAge()) return +1;
////        else return 0;
//        return a.getAge().
//    }
}
