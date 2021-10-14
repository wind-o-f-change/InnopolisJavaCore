package part1.lesson08;

/**
 * Create 17.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Wheel {
    int diameter;
    private String width;
    private Some some;

    public Some getSome() {
        return some;
    }

    public Wheel setSome(Some some) {
        this.some = some;
        return this;
    }

    void print() {
        System.out.println("\tI'm wheel");
    }

    public Wheel(int diameter, String width, Some some) {
        this.diameter = diameter;
        this.width = width;
        this.some = some;
    }

    public Wheel(){}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Wheel{");
        sb.append("diameter=").append(diameter);
        sb.append(", width='").append(width).append('\'');
        sb.append(", ").append(some.toString());
        sb.append('}');
        return sb.toString();
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
