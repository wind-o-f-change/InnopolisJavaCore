package part1.lesson02.task03;

/**
 * Create 23.04.2020
 *
 * This class contains String constants
 *
 * @author Evtushenko Anton
 */

public class Sex {
    //будьте последовательны в именовании
    private static final String getMAN = "MAN";
    private static final String WOMAN = "WOMAN";

    // для констант геттеры обычно не делают
    public static String getMAN() {
        return getMAN;
    }

    public static String getWOMAN() {
        return WOMAN;
    }

    private Sex(){};
}
