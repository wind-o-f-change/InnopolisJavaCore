package part1.lesson08;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Create 18.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Main {

    public static void main(String[] args) {
        Car car = new Car("2120", "Uaz", new Wheel(25, "225"));

//        String carObj = "Car.txt";
        serialize(car);
//        Car car2 = (Car) deSerialize(carObj, Car.class);

        System.out.println(car);
//        car.beep();
//        car.wheel.print();

//        System.out.println("\nIt's a copy of the Uaz\n\t" + car2);
//        car2.beep();
//        car2.wheel.print();
    }

    private static <T> void serialize(T object) {
        Field[] parentFields = object.getClass().getSuperclass().getDeclaredFields();
        Field[] fields = object.getClass().getDeclaredFields();

        serializator(object, fields);
        parentPrint(object, object.getClass(), parentFields);
    }

//    private static void serializeTwo(Object object) {
//
//        Field[] parentFields = object.getClass().getSuperclass().getDeclaredFields();
//        Field[] fields = object.getClass().getDeclaredFields();
//
//        serializator(object, parentFields);
//        serializator(object, fields);
//    }

    private static void serializator(Object object, Field[] fields) {
        try {
            for (Field field : fields) {
                field.setAccessible(true);

                Class<?> clazz = field.get(object).getClass();
                if (clazz == String.class) {
                    String s = "@val";
                    field.set(object, (s));
                } else if (clazz.isPrimitive() || clazz.getSuperclass().getSimpleName().equals("Number")) {
                    field.set(object, field.get(object));
                } else if (Arrays.asList(clazz.getInterfaces()).contains(Serializable.class)) {
                    field.set(object, field.get(object));
                } else {
                    serialize(field.get(object));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static <T> void parentPrint(T object, Class<?> clazz, Field[] fields) {
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println(field.getName());

                Class<?> subClazz = field.get(object).getClass();
                if (subClazz == String.class) {
                    String s = "@my val";
                    field.set(object, (s));
                }
                Class<?> superclass = clazz.getSuperclass();
                if (superclass != null){
                    parentPrint(object, superclass, superclass.getDeclaredFields());
                }
            }


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

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

    private static void deSerializeTwo(Object changeValue, Field changeField, ObjectInputStream ois) {
        try {
            Class<?> type = changeField.getType();
            Object obj = type.newInstance();

            Field[] parentFields = type.getSuperclass().getDeclaredFields();
            Field[] fields = type.getDeclaredFields();

            deSerializator(obj, parentFields, ois);
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

                if (o2Class == String.class) {
                    field.set(obj, (String) ois.readObject());
                } else if (field.getType().isPrimitive() || o2Class.getSuperclass().getSimpleName().equals("Number")) {
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