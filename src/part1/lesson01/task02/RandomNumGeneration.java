package part1.lesson01.task02;

/**
 * Create 23.04.2020
 * @autor Evtushenko Anton
 *
 * This method prints to the console information about the coincidence of numbers and their square roots
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

        int k;                                    // parameter numbers for the "intsK" array
        int q;                                    // parameter square root from numbers for the "intsQ" array

        int[] intsK = new int[numCycle];          // Values array
        int[] intsQ = new int[numCycle];          // sqrt(Value) array

        // Initialization cycle for the "intsK" and the "intsQ" arrays
        for (int i = 0; i < numCycle; i++) {
            int indexArr = (int) (genNumCycle.length * Math.random() - 1);
            if (indexArr < 0) indexArr = 0;

            k = genNumCycle[indexArr]; // selecting a random number from the "genNumCycle" array

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

            for (int j = 0; j < numCycle; j++) {
//                System.out.printf("q = %d, k = %d\n", q, intsK[j]);               //It's for you to test watch
                if (q == intsK[j]) System.out.println("a match is found: " + q);
            }
        }
    }
}
