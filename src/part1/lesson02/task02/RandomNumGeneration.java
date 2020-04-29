package part1.lesson02.task02;

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

        int numCycle = (int) (9 * Math.random()); // Generation "N" random numbers //(сколько должно быть чисел)

        // переменный лучше объявлять как можно ближе к их использованию. Вне цикла они не нужны
        int k;                                    // parameter numbers for the "intsK" array
        int q;                                    // parameter square root from numbers for the "intsQ" array

        int[] intsK = new int[numCycle];          // Values array
        int[] intsQ = new int[numCycle];          // sqrt(Value) array

        // Initialization cycle for the "intsK" and the "intsQ" arrays
        for (int i = 0; i < numCycle; i++) {
            int indexArr = (int) (genNumCycle.length * Math.random() - 1);
            if (indexArr < 0) indexArr = 0;

            // чем не устроил Random.nextInt()? :)
            k = genNumCycle[indexArr]; // selecting a random number from the "genNumCycle" array

            // думайте об информативности, не лишним будет вывести само число
            if (k < 0)
                throw new MyNegativeNumberException("Negative numbers are not allowed!!");       // Exception if "k" is negative

            intsK[i] = k;

            q = (int) Math.sqrt(k);
            intsQ[i] = q;
        }

        /* Algorithm to check for matches "k" and "q" with prints to the console
         information about the coincidence of numbers and their square roots*/
        for (int i = 0; i < numCycle; i++) {
            q = intsQ[i];

            // речь шла не о том, чтобы найти среди k равное q, а чтобы вывести такие q, квадрат целой части, которых равен k, из которого они получились
            // например 9 и 3 подходят под это условие, а 5 и 2 с лишним нет.
            for (int j = 0; j < numCycle; j++) {
//                System.out.printf("q = %d, k = %d\n", q, intsK[j]);               //It's for you to test watch
                if (q == intsK[j]) System.out.println("a match is found: " + q);
            }
        }
    }
}
