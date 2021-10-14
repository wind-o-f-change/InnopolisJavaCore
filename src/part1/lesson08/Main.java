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
    /** Показывать ли историю посещения полей во время обхода */
    static boolean isOnHistoryReflectionWork = false;

    public static void main(String[] args) {

        Some some = new Some("что - то", new SuperSome("super что - то"));
        Car car = new Car(2120, "Uaz", new Wheel(25, "225", some));

        System.out.println(car);
        System.out.println();
        serialize(car);

        System.out.println('\n' + car.toString());
    }

    private static <T> void serialize(T object) {
        Class clazz = object.getClass();
        Class superClass = clazz.getSuperclass();

        serializator(object, clazz.getDeclaredFields());
        parentSerialize(object, superClass, superClass.getDeclaredFields());
    }

    private static <T> void serializator(T object, Field[] fields) {
        if (isOnHistoryReflectionWork) System.out.println("serializator " + object.getClass().getSimpleName() + ": ");
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (isOnHistoryReflectionWork) System.out.println(field.getType().getSimpleName() + ": " + field.getName());

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

    private static <T> void parentSerialize(T object, Class<?> clazz, Field[] fields) {
        if (isOnHistoryReflectionWork) System.out.println("parentSerialize " + object.getClass().getSimpleName() + ": ");
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (isOnHistoryReflectionWork) System.out.println(field.getType().getSimpleName() + ": " + field.getName());

                Class<?> subClazz = field.get(object).getClass();
                if (subClazz == String.class) {
                    String s = "@parent val";
                    field.set(object, (s));
                } else if (!(clazz.isPrimitive() || clazz.getSuperclass().getSimpleName().equals("Number"))) {
                    serialize(field.get(object));
                }
                Class<?> superclass = clazz.getSuperclass();
                if (superclass != null){
                    parentSerialize(object, superclass, superclass.getDeclaredFields());
                }
            }


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}