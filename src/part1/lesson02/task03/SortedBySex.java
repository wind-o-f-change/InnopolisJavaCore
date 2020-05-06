package part1.lesson02.task03;

/**
 * Create 23.04.2020
 *
 * This class sorts instances of the Person class by sex
 *
 * @author Evtushenko Anton
 */

public class SortedBySex implements Sorter {
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
//    @Override
//    public int compare(Object o1, Object o2) {
//        Person a = (Person) o1;
//        Person b = (Person) o2;
//
//        return a.getName().compareTo(b.getName());
//    }
}
