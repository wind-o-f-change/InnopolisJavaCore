package part1.lesson01.task03;

/**
 * Create 23.04.2020
 *
 * @autor Evtushenko Anton
 */

public class Test {
    public static void main(String[] args) {
        String s = "Abcd";
        String end = "zxCv";
        System.out.println(s.compareTo(end));
        System.out.println(s.compareToIgnoreCase(end));
        System.out.println(end.compareTo(s));
        System.out.println(end.compareToIgnoreCase(s));
    }
}
