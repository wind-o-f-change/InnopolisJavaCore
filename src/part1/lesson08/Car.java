package part1.lesson08;

/**
 * Create 17.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Car extends Entitity {
    private int speed;
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


    public Car(int speed, String name) {
        this.speed = speed;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", name='" + name + '\'' +
                ", wheel= " + wheel +
                '}' + "\n\t\t extend field = " + Car.extStr;
    }
}
