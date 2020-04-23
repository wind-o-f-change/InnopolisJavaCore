package part1.lesson01.task01;

/**
 * Create 23.04.2020
 *
 * @autor Evtushenko Anton
 */

public class HelloWorldForNPE {
    public static void main(String[] args){

        Integer x = null;

        int exception = 3 / x;
    }
}
