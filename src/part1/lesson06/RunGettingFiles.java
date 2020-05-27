package part1.lesson06;

/**
 * Create 25.05.2020
 *
 * @autor Evtushenko Anton
 */

public class RunGettingFiles {

    public static void main(String[] args) {

            new Generator().getFiles("D:/OOP/Inno/",5, 55000, 10
                    //такой массив выбран для наглядности
                    , new String[]{" $_One_$ ", " $_Two_$ ", " $_Tree_$ "});
    }
}