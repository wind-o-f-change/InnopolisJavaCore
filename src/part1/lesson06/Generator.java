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
                Path filePath = Paths.get(path + i + ".txt");

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
        System.out.println("Files are recorded !!!");
    }

    private byte[] getFile(int size, int probability, String[] randomWords) {
        StringBuilder file = new StringBuilder(size);
        Random random = new Random();
        int remainingSize = size;

        while (remainingSize > 0) {
            String s = paragraphGen(remainingSize - 2, probability, randomWords);
            file.append(s);
            file.append("\n\t");
            remainingSize -= (s.length() + 2);
        }
        int fileLength = file.length();
        char[] chars = ".!?".toCharArray();
        file.setCharAt(fileLength - 2, chars[random.nextInt(3)]);
        file.setCharAt(fileLength - 1, ' ');

        if (file.length() != size)
            throw new IllegalArgumentException(" Упс !!! file capacity is: " + file.length() + " != " + size);
        return file.toString().getBytes();
    }

    private String paragraphGen(int remainingSize, int probability, String[] randomWords) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < random.nextInt(20) + 1; i++) {
            sb.append(sentenceGen(probability, randomWords, random));
            if (sb.length() > remainingSize) return sb.substring(0, remainingSize);
        }
        return sb.toString();
    }

    private String sentenceGen(int probability, String[] randomWords, Random random) {

        boolean isFirst = false;
        StringBuilder sentence = new StringBuilder();

        int cycle = random.nextInt(15) + 1;
        for (int i = 0; i < cycle; i++) {

            if (probability >= random.nextInt(101)) {
                sentence.append(randomWords[random.nextInt(randomWords.length)]);
                continue;
            }

            if (i == 0) {
                isFirst = true;
            } else if (i == 1) {
                isFirst = false;
            }

            sentence.append(wordGen(isFirst, random));

            if (i != cycle - 1) sentence.append(' ');
        }

        char[] chars = ".!?".toCharArray();
        sentence.append(
                chars[random.nextInt(3)]
        );

        sentence.append(' ');

        return sentence.toString();
    }

    private String wordGen(boolean isFirst, Random random) {

        int numCharsName = random.nextInt(15) + 1;
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder word = new StringBuilder(numCharsName);

        // Word creation cycle
        boolean toUpper = isFirst;
        for (int i = 0; i < numCharsName; i++) {
            char c = chars[random.nextInt(chars.length)];

            if (toUpper && i == 0) {
                word.append(String.valueOf(c).toUpperCase());
                toUpper = false;
            } else word.append(c);
        }
        return word.toString();
    }
}