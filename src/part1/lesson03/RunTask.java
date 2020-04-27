package part1.lesson03;

import part1.lesson03.MathBox;

import java.text.NumberFormat;

/**
 * Create 26.04.2020
 *
 * @autor Evtushenko Anton
 */

public class RunTask {
    public static void main(String[] args) {
        MathBox m = new MathBox(new Number[]{10,3.2f, 1.8d, 5l});
        m.dump();
        System.out.println("\n" + m.summator());
        m.separator(2.0);
        m.dump();
    }
    private RunTask(){}
}
