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

    /**
     * This method adds an object to a list of objects
     * @param o - Added object
     */
    public void addObject(Object o){
        objectList.add(o);
    }

    /**
     * This method delete object of list
     * @param o removable object
     */
    public void deleteObject(Object o){
        objectList.removeAll(Arrays.asList(o));
    }

    /**
     * This method outputs the contents of the collection in a string.
     */
    public void dump() {
        System.out.print("Content from the ObjectBox list : ");
        objectList.forEach(v -> System.out.print(v + " "));
    }
}
