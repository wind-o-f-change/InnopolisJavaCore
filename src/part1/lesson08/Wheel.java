package part1.lesson08;

import java.io.Serializable;

/**
 * Create 17.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Wheel implements Serializable {
    private static long serialVersionUID = 1L;
    int diameter;

    void print() {
        System.out.println("I'm wheel");
    }

    public Wheel(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "diameter=" + diameter +
                '}';
    }
}
