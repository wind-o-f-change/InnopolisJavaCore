package part1.lesson01.task02;

/**
 * Create 23.04.2020
 *
 * @autor Evtushenko Anton
 */

public class MyNegativeNumberException extends RuntimeException {

    private MyNegativeNumberException(){}

    public MyNegativeNumberException(String s) {
        System.err.println(s);
    }
}
