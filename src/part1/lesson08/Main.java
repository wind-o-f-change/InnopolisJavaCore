package part1.lesson08;

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

        System.out.println(car);
        System.out.println();
        serialize(car);

        System.out.println('\n' + car.toString());
    }

    private static <T> void serialize(T object) {
        Class clazz = object.getClass();
        Class superClass = clazz.getSuperclass();

        serializator(object, clazz.getDeclaredFields());
        parentPrint(object, superClass, superClass.getDeclaredFields());
    }

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
                System.out.println(clazz.getSimpleName() + ": " + field.getName());

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
}