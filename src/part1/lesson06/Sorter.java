package part1.lesson06;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.AccessException;
import java.util.*;

/**
 * Create 29.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Sorter {

    public void runner(File readingFile, String pathToWrite) {
        write(read(readingFile), pathToWrite);
        System.out.println("Task 1 completed\n\tFiles are sorted and rerecorded to " + pathToWrite + " !!!");
    }

    private Set<String> read(File readingFile) {
        TreeSet<String> strings = new TreeSet<>(String::compareToIgnoreCase);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(readingFile)))) {
            while (br.ready()) {
                List<String> arrayStr = Arrays.asList(br.readLine().split("\\p{Punct}"));
                arrayStr.forEach(v -> strings.addAll(Arrays.asList(v.split(" "))));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        strings.remove("");

        return strings;
    }

    private void write(Set<String> strings, String paths) {
        File file = Paths.get(paths).toFile();
        try(BufferedWriter br = new BufferedWriter(new FileWriter(paths))) {
            if (!file.exists()) {
                file.createNewFile();
            }

            if (file.canWrite()) {
                for (String v : strings) {
                    br.write(v);
                    br.newLine();
                    System.out.println(v);
                }
            } else throw new AccessException("File can't write ./-_-/. ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
