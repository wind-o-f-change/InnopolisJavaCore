package part1.lesson08;

/**
 * Create 17.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Wheel {
    int diameter;
    private String width;

    void print() {
        System.out.println("\tI'm wheel");
    }

    public Wheel(int diameter, String width) {
        this.diameter = diameter;
        this.width = width;
    }

    public Wheel(){}

    @Override
    public String toString() {
        return "Wheel{" +
                "diameter=" + diameter +
                ", width='" + width + '\'' +
                '}';
    }
}
