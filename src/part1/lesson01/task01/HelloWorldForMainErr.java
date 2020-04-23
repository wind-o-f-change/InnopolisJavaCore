package part1.lesson01.task01;

/**
 * Create 23.04.2020
 *
 * @autor Evtushenko Anton
 */

public class HelloWorldForMainErr {
    public static void main(String[] args) throws MainErrExceptions {
        throw new MainErrExceptions("It's trow my Class Exception");
    }
}
