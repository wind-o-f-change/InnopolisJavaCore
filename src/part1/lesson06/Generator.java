package part1.lesson06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.AccessException;
import java.util.Random;

/**
 * Create 25.05.2020
 *
 * @autor Evtushenko Anton
 */

public class Generator {
    private Random random = new Random();
    private char[] chars = ".!?".toCharArray();
    private char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * The method that creates "n" files of a given size in the "path" directory
     * using a word from an array with a given probability
     *
     * @param path path to file
     * @param n quantity of files
     * @param size files size(byte)
     * @param probability probability that one of the words in the "words" array will be included in the next sentence
     * @param words array of words, one of which will be included in the next sentence with a set probability
     */
    public void getFiles(String path, int n, int size, int probability, String[] words) {
        try {
            for (int i = 0; i < n; i++) {
                Path directoryPath = Paths.get(path);
                File directory = directoryPath.toFile();
                Path filePath = Paths.get(path + '/' + i + ".txt");

                if (!directory.exists()) {
                    Files.createDirectory(directoryPath);
                }

                if (directory.canWrite()) {
                    Files.write(filePath, getFile(size, probability, words), StandardOpenOption.CREATE);
                } else throw new AccessException("Files can't write -> Access Exception");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Task 2 completed\n\tFiles are recorded !!!");
    }

    private byte[] getFile(int size, int probability, String[] randomWords) {
        StringBuilder file = new StringBuilder(size);

        while (size - file.length() > 0) {
            file.append(paragraphGen((size - file.length()) - 2, probability, randomWords));
            file.append("\r\n");
        }

        int fileLength = file.length();
        file.setCharAt(fileLength - 2, chars[random.nextInt(3)]);
        file.setCharAt(fileLength - 1, ' ');

        if (fileLength != size)
            throw new IllegalArgumentException(" Упс !!! file capacity is: " + fileLength + " != " + size);
        return file.toString().getBytes();
    }

    private String paragraphGen(int remainingSize, int probability, String[] randomWords) {
        StringBuilder paragraph = new StringBuilder();

        for (int i = 0; i < random.nextInt(20) + 1; i++) {
            paragraph.append(sentenceGen(probability, randomWords));
            if (paragraph.length() > remainingSize) return paragraph.substring(0, remainingSize);
        }
        return paragraph.toString();
    }

    private String sentenceGen(int probability, String[] randomWords) {
        StringBuilder sentence = new StringBuilder();

        int cycle = random.nextInt(15) + 1;
        for (int i = 0; i < cycle; i++) {

            if (probability >= random.nextInt(101)) {
                sentence.append(randomWords[random.nextInt(randomWords.length)]);
                continue;
            }

            sentence.append(wordGen((i == 0)));

            if (i != cycle - 1) sentence.append(' ');
        }

        sentence.append(
                chars[random.nextInt(3)]
        );

        sentence.append(' ');

        return sentence.toString();
    }

    private String wordGen(boolean toUpper) {

        int numCharsName = random.nextInt(15) + 1;
        StringBuilder word = new StringBuilder(numCharsName);

        for (int i = 0; i < numCharsName; i++) {
            char c = letters[random.nextInt(letters.length)];

            if (toUpper && i == 0) {
                word.append(String.valueOf(c).toUpperCase());
            } else word.append(c);
        }
        return word.toString();
    }
}