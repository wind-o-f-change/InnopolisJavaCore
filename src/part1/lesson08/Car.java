package part1.lesson08;

/**
 * Create 17.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Car extends Entity {
    int speed;
    String name;
    Wheel wheel;

    void beep() {
        System.out.println("\tbee - bee");
    }

    public Car(){}

    public Car(int speed, String name, Wheel wheel) {
        this.speed = speed;
        this.name = name;
        this.wheel = wheel;
    }

    public int getSpeed() {
        return speed;
    }

    public Car setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public String getName() {
        return name;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public Car setWheel(Wheel wheel) {
        this.wheel = wheel;
        return this;
    }

    public Car(int speed, String name) {
        this.speed = speed;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("\n\taverageField='").append(averageField).append('\'');
        sb.append(", \n\tspeed=").append(speed);
        sb.append(", \n\tname='").append(name).append('\'');
        sb.append(", \n\twheel=").append(wheel);
        sb.append(", \n\textStr='").append(extStr).append('\'');
        sb.append(", \n\tmegaSuperEntityField='").append(megaSuperEntityField).append('\'');
        sb.append(", \n\tsuperWheel=").append(superWheel);
        sb.append('}');
        return sb.toString();
    }
}
