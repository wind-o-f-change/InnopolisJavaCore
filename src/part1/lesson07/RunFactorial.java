package part1.lesson07;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

/**
 * Create 13.05.2020
 *
 * @autor Evtushenko Anton
 */

public class RunFactorial {
    static HashMap<Integer, BigInteger> cache = new HashMap<>();

    public static void main(String[] args) {
        Random random = new Random();
        // Иммитация массива из рандом чисел
        for (int i = 0; i < random.nextInt(10000); i++) new Thread(() -> System.out.println(factorial(random.nextInt(10000)))).start();
    }

    static BigInteger factorial(int n) {
        BigInteger ret;

        if (n == 0) return BigInteger.ONE;
        if (null != (ret = cache.get(n))) return ret;
        ret = BigInteger.valueOf(n);
        for (int i = 1; i < n; ++i)
            ret = ret.multiply(BigInteger.valueOf(i));
        cache.put(n, ret);
        return ret;
    }
}