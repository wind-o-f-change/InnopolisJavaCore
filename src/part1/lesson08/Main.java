package part1.lesson08;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Create 18.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Main {

    public static void main(String[] args) {
//        Car car = new Car(2120, "Uazik", new Wheel(25, "225", new Bolt("\"Mounting bolt\"")));
        Car car = new Car(2120, "Uazik", new Wheel(25, "225"));//, new Bolt("\"Mounting bolt\"")));

        String carObj = "Car";
        serialize(car, carObj);
        Car car2 = (Car) deSerialize(carObj, Car.class);

        System.out.println("\nIt's an original UAZ\n\t" + car);
        car.beep();
        car.wheel.print();

        System.out.println("\nIt's a copy of the Uaz\n\t" + car2);
        car2.beep();
        car2.wheel.print();
    }

    static void serialize(Object object, String file) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))) {
            // Алгоритм копирования объекта на один уровень вложенности
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);

                Class<?> oClass = field.get(object).getClass();
                if (oClass.isPrimitive() || oClass.getSuperclass().getSimpleName().equals("Number")) {
                    ous.writeObject(field.get(object));

                } else if (Arrays.asList(oClass.getInterfaces()).contains(Serializable.class)) {
                    ous.writeObject(field.get(object));
                } else {
                    serializeTwo(field.get(object), ous);
                }
//                else {
//                    Field[] fields2 = o.getClass().getDeclaredFields();
//                    for (Field field2 : fields2) {
//                        field2.setAccessible(true);
//                        ous.writeObject(field2.get(o));
//                    }
//                }
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static void serializeTwo(Object object, ObjectOutputStream ous) {
        try {
            // Алгоритм копирования объекта на один уровень вложенности
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);

                Class<?> clazz = field.get(object).getClass();
                if (clazz.isPrimitive() || clazz.getSuperclass().getSimpleName().equals("Number")) {
                    ous.writeObject(field.get(object));

                } else if (Arrays.asList(clazz.getInterfaces()).contains(Serializable.class)) {
                    ous.writeObject(field.get(object));
                } else {
                    serializeTwo(field.get(object), ous);
                }
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static Object deSerialize(String file, Class<?> clazz) {
        Object obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            obj = clazz.newInstance();

            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);

                Class<?> oClass = field.getType();
//                Object zxc = null;

                if (field.getType().isPrimitive() || oClass.getSuperclass().getSimpleName().equals("Number")) {
                    field.set(obj, ois.readObject());
                } else if (Arrays.asList(oClass.getInterfaces()).contains(Serializable.class)) {
                    field.set(obj, ois.readObject());
                } else {
//                    String s = field.getType().getSimpleName();
                    deSerializeTwo(field, obj, ois);
//                    deSerialize(ois, ois.readObject().getClass());
                }
            }
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    static void deSerializeTwo(Field field, Object changeVal, ObjectInputStream ois) {
        try {
            Class<?> type = field.getType();
            Object obj = type.newInstance();
            Field[] fields2 = type.getDeclaredFields();

            for (Field field2 : fields2) {
                field2.setAccessible(true);

                Class<?> o2Class = field2.getType();

                if (field2.getType().isPrimitive() || o2Class.getSuperclass().getSimpleName().equals("Number")) {
                    field2.set(obj, ois.readObject());
                } else if (Arrays.asList(o2Class.getInterfaces()).contains(Serializable.class)) {
                    field2.set(obj, ois.readObject());
                } else {
                    deSerializeTwo(field2, obj, ois);
                }
            }
            field.set(changeVal, obj);
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}