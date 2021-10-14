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
                ", width='" + width +
                '}';
    }

    public int getDiameter() {
        return diameter;
    }

    public Wheel setDiameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    public String getWidth() {
        return width;
    }

    public Wheel setWidth(String width) {
        this.width = width;
        return this;
    }
}
