package part1.lesson02.task01;

/**
 * Create 23.04.2020
 *
 * @autor Evtushenko Anton
 */

public class MainErrExceptions extends ArrayStoreException {

    private MainErrExceptions(){}

    public MainErrExceptions(String s) {
        System.err.println(s);
    }
}
