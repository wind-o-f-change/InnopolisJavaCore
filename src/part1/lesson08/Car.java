package part1.lesson08;

import java.io.*;

/**
 * Create 17.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Car implements Serializable {


    private static long serialVersionUID = 1L;
    private int speed;
    String name;
    Wheel wheel;

    void beep() {
        System.out.println("bee - bee");
    }

    public Car(){}

    public Car(int speed, String name, Wheel wheel) {
        this.speed = speed;
        this.name = name;
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", name='" + name + '\'' +
                ", wheel=" + wheel +
                '}';
    }
}
