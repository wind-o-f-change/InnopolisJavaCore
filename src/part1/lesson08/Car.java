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

    static void serialize(Object object, String file) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))) {
            ous.writeObject(object);
        } catch (IOException e) {
            System.out.println("Упс ...serialize... /-_-/");
            e.printStackTrace();
        }

    }

    static Object deSerialize(String file) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            System.out.println("Упс ...deSerialize... /-_-/");
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.out.println("Упс ...IOException... 3 /-_-/");
                e.printStackTrace();
            }
        }
        return obj;
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
