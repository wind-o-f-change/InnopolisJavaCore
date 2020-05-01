package part1.lesson02.task02;

import java.util.Random;

import static java.lang.Math.random;
import static java.lang.Math.sqrt;

/**
 * Create 23.04.2020
 * @autor Evtushenko Anton
 *
 * This class prints to the console information about the coincidence of numbers and their square roots
 */

public class RandomNumGeneration {

    public static void main(String[] args) {
        // Creating number array for number generation
        int[] genNumCycle = new int[200];
        int startGenerationNum = -10;             // 5% chance of a negative number

        //Generation number array for current task
        for (int i = 0; i < genNumCycle.length; i++) {
            genNumCycle[i] = startGenerationNum++;
        }

        int numCycle = (int) (9 * random());      // Generation "N" random numbers //(сколько должно быть чисел)

        int[] intsK = new int[numCycle];          // Values array
        int[] intsQ = new int[numCycle];          // sqrt(Value) array

        // Initialization cycle for the "intsK" and the "intsQ" arrays
        for (int i = 0; i < numCycle; i++) {

            int k = genNumCycle[new Random().nextInt(       // selecting a random number from the "genNumCycle" array
                    (genNumCycle.length - 2) + 1)];

            if (k < 0) {
                throw new MyNegativeNumberException(                   // Exception if "k" is negative
                        String.format(
                                "k= %d. This is a negative number, they are not allowed!!", k));
            }

            intsK[i] = k;
            intsQ[i] = (int) sqrt(k);           // parameter square root from numbers for the "intsQ" array
        }

        /* Algorithm to check for matches "k" and "q" with prints to the console
         information about the coincidence of numbers and their square roots*/
        for (int i = 0; i < numCycle; i++) {
            int q = intsQ[i];

            for (int j = 0; j < numCycle; j++) {
//                System.out.printf("k = %d, q = %d\n", intsK[j], q);               //It's for you to test watch
                if (q*q == intsK[j]) System.out.println(String.format("a match is found: %d and %d",intsK[j], q));
            }
        }
    }
}
