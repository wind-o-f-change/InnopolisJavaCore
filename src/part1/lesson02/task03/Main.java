package part1.lesson02.task03;

/**
 * Create 23.04.2020
 * This class for run tasks
 * @autor Evtushenko Anton
 */

public class Main {
    public static void main(String[] args) {
        PersonStore store = new PersonStore(300);
        store.runTask(new SortedByAge());
        store.runTask(new SortedByName());
        store.runTask(new SortedBySex());
        store.runTask(new SortedBySex().thenComparing(new SortedByAge().thenComparing(new SortedByName())));
    }

    private Main(){}
}
