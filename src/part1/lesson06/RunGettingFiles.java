package part1.lesson06;

import java.io.File;

/**
 * Create 25.05.2020
 *
 * @autor Evtushenko Anton
 */

public class RunGettingFiles {

    public static void main(String[] args) {

        // Task 2
        new Generator().getFiles("files", 1, 55000, 10
                //такой массив выбран для наглядности
                , new String[]{" $_One_$ ", " $_Two_$ ", " $_Three_$ "});

        // Task 1
        new Sorter().runner(new File("files/0.txt"), "files/007.txt");
    }
}