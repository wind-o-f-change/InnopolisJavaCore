package part1.lesson08;

import java.io.*;

/**
 * Create 17.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Car implements Serializable {
    private static long serialVersionUID = 1L;
    int speed;
    String name;
    Wheel wheel;

    void beep() {
        System.out.println("bee - bee");
    }

    public static void main(String[] args) {
        Car car = new Car(250, "Uaz", new Wheel(20));

        ObjectOutputStream ous;
        ObjectInputStream ois;
        Car car2 = null;
        try {
            ous = new ObjectOutputStream(new FileOutputStream("Car"));
            ous.writeObject(car);

            ois = new ObjectInputStream(new FileInputStream("Car"));
            car2 = (Car) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("УПС /-_-/");
            e.printStackTrace();
        }

        System.out.println(car);
        car.beep();
        car.wheel.print();

        System.out.println(car2);
        car2.beep();
        car2.wheel.print();
    }

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
