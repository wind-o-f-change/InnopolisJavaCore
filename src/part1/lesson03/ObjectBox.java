package part1.lesson03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create 27.04.2020
 *
 * @autor Evtushenko Anton
 */

public class ObjectBox {
    private List<Object> objectList = new ArrayList<>();

    public ObjectBox() {
    }

    public void addObject(Object o){
        objectList.add(o);
    }

    public void deleteObject(Object o){
        objectList.removeAll(Arrays.asList(o));
    }

    public void dump() {
        System.out.print("Content from the ObjectBox list : ");
        objectList.forEach(v -> System.out.print(v + " "));
    }
}
