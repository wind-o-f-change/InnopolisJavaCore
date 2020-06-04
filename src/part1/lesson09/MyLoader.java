package part1.lesson09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Create 01.06.2020
 *
 * @autor Evtushenko Anton
 */

public class MyLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if ("SomeClass".equals(name)) {
            return findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        if ("SomeClass".equals(name)) {
            try {
                byte[] clazz = Files.readAllBytes(Paths.get("./src/part1/lesson09/SomeClass.class"));
                return defineClass(name, clazz, 0, clazz.length);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
