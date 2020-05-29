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
        Car car = new Car(2120, "Uaz", new Wheel(25, "225"));

        String carObj = "Car";
        serialize(car, carObj);
        Car car2 = (Car) deSerialize(carObj, Car.class);

        System.out.println("\nIt's an original Uaz\n\t" + car);
        car.beep();
        car.wheel.print();

        System.out.println("\nIt's a copy of the Uaz\n\t" + car2);
        car2.beep();
        car2.wheel.print();
    }

    /**
     * This method serialized "object" through reflection API.
     *
     * @param object a serializable object
     * @param file   a path to an object file
     */
    private static void serialize(Object object, String file) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))) {
            // Алгоритм копирования объекта на один уровень вложенности
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);

                Class<?> oClass = field.get(object).getClass();
                if (oClass.isPrimitive() || oClass.getSuperclass().getSimpleName().equals("Number")) {
                    ous.writeObject(field.get(object));

                    //Boolean отработает здесь
                } else if (Arrays.asList(oClass.getInterfaces()).contains(Serializable.class)) {
                    ous.writeObject(field.get(object));
                } else {
                    serializeTwo(field.get(object), ous);
                }
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method serialized "object" through reflection API.
     * It is used for serializing a nested object.
     *
     * @param object a serializable object
     * @param ous    a stream to an object file for serialization
     */
    private static void serializeTwo(Object object, ObjectOutputStream ous) {
        try {
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

    /**
     * This method deserialize "object" through reflection API.
     *
     * @param file  a path to an object file of his to be deserializable
     * @param clazz a class of an object to be deserializable.
     *
     * @return
     */
    private static Object deSerialize(String file, Class<?> clazz) {
        Object obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            obj = clazz.newInstance();

            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);

                Class<?> oClass = field.getType();

                if (field.getType().isPrimitive() || oClass.getSuperclass().getSimpleName().equals("Number")) {
                    field.set(obj, ois.readObject());
                } else if (Arrays.asList(oClass.getInterfaces()).contains(Serializable.class)) {
                    field.set(obj, ois.readObject());
                } else {
                    deSerializeTwo(obj, field, ois);
                }
            }
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * This method deserialize "object" through reflection API.
     * It is used for serializing a nested object.
     *
     * @param changeField
     * @param changeValue an object which to be deserialize
     * @param ois         a stream to an object file for deserialization
     *
     * @return
     */
    private static void deSerializeTwo(Object changeValue, Field changeField, ObjectInputStream ois) {
        try {
            Class<?> type = changeField.getType();
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
                    deSerializeTwo(obj, field2, ois);
                }
            }
            changeField.set(changeValue, obj);
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}