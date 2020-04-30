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

        int numCycle = (int) (9 * random()); // Generation "N" random numbers //(сколько должно быть чисел)

        // переменный лучше объявлять как можно ближе к их использованию. Вне цикла они не нужны
        int[] intsK = new int[numCycle];          // Values array
        int[] intsQ = new int[numCycle];          // sqrt(Value) array

        // Initialization cycle for the "intsK" and the "intsQ" arrays
        for (int i = 0; i < numCycle; i++) {
            int indexArr = new Random().nextInt(genNumCycle.length - 1);
            if (indexArr < 0) indexArr = 0;

            // чем не устроил Random.nextInt()? :)
            int k = genNumCycle[indexArr]; // parameter numbers for the "intsK" array
                                           // selecting a random number from the "genNumCycle" array
            // думайте об информативности, не лишним будет вывести само число
            if (k < 0) {
                throw new MyNegativeNumberException(                   // Exception if "k" is negative
                        String.format(
                                "k= %d. This is a negative number, they are not allowed!!", k));
            }

            intsK[i] = k;

            int q = (int) sqrt(k);         // parameter square root from numbers for the "intsQ" array
            intsQ[i] = q;
        }

        /* Algorithm to check for matches "k" and "q" with prints to the console
         information about the coincidence of numbers and their square roots*/
        for (int i = 0; i < numCycle; i++) {
            int q = intsQ[i];

            // речь шла не о том, чтобы найти среди k равное q, а чтобы вывести такие q, квадрат целой части, которых равен k, из которого они получились
            // например 9 и 3 подходят под это условие, а 5 и 2 с лишним нет.
            for (int j = 0; j < numCycle; j++) {
//                System.out.printf("k = %d, q = %d\n", intsK[j],q);               //It's for you to test watch
                if (q*q == intsK[j]) System.out.println(String.format("a match is found: %d and %d",intsK[j], q));
            }
        }
    }
}
