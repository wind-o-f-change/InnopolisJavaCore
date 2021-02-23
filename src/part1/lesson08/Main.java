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

        String carObj = car.getClass().getSimpleName();
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
            // Алгоритм копирования объекта
//            Field[] parentFields = object.getClass().getSuperclass().getDeclaredFields();
            Field[] fields = object.getClass().getDeclaredFields();

//            serializator(object, parentFields, ous);
            serializator(object, fields, ous);

        } catch (IOException e) {
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

        Field[] parentFields = object.getClass().getSuperclass().getDeclaredFields();
        Field[] fields = object.getClass().getDeclaredFields();

        serializator(object, parentFields, ous);
        serializator(object, fields, ous);
    }

    private static void serializator(Object object, Field[] fields, ObjectOutputStream ous) {
        try {
            for (Field field : fields) {
                field.setAccessible(true);

                Class<?> clazz = field.get(object).getClass();
                if (clazz.isPrimitive()
                        || clazz.getSuperclass().getSimpleName().equals("Number")
                        || Arrays.asList(clazz.getInterfaces()).contains(Serializable.class)
                ) {
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

            Field[] parentFields = clazz.getSuperclass().getDeclaredFields();
            Field[] fields = clazz.getDeclaredFields();

            deSerializator(obj, parentFields, ois);
            deSerializator(obj, fields, ois);

        } catch (IOException | IllegalAccessException | InstantiationException e) {
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

            Field[] parentFields = type.getSuperclass().getDeclaredFields();
            Field[] fields = type.getDeclaredFields();

//            deSerializator(obj, parentFields, ois);
            deSerializator(obj, fields, ois);

            changeField.set(changeValue, obj);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void deSerializator(Object obj, Field[] fields, ObjectInputStream ois) {
        for (Field field : fields) {
            field.setAccessible(true);

            Class<?> o2Class = field.getType();
            try {

                if (field.getType().isPrimitive() || o2Class.getSuperclass().getSimpleName().equals("Number")) {
                    field.set(obj, ois.readObject());
                } else if (Arrays.asList(o2Class.getInterfaces()).contains(Serializable.class)) {
                    field.set(obj, ois.readObject());
                } else {
                    deSerializeTwo(obj, field, ois);
                }
            } catch (IllegalAccessException | IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}