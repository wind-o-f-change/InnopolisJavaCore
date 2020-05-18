package part1.lesson08;

import java.io.*;

import static part1.lesson08.Car.deSerialize;
import static part1.lesson08.Car.serialize;

/**
 * Create 18.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Main {
    public static void main(String[] args) {
        Car car = new Car(250, "Uaz", new Wheel(20));

        String carObj = "Car";
        serialize(car, carObj);
        Car car2 = (Car) deSerialize(carObj);

        System.out.println("It's a 1_" + car);
        car.beep();
        car.wheel.print();

        System.out.println("It's a 2_" + car2);
        car2.beep();
        car2.wheel.print();
    }
}
