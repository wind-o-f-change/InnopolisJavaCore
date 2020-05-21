package part1.lesson08;

import java.io.*;
import java.lang.reflect.Field;

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

    static void serialize(Object object, String file) {
        Object o = null;
        try {
            o = object.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            try {
                field.set(o, field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))) {
            ous.writeObject(o);
        } catch (IOException e) {
            System.out.println("Упс ...serialize... /-_-/");
            e.printStackTrace();
        }
    }

    static Object deSerialize(String file) {
        Object obj = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
             obj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(String.format("Упс ...deSerialize... %s /-_-/", e));
            e.printStackTrace();
        }
        return obj;
    }
}