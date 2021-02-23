package part1.lesson07;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Create 13.05.2020
 *
 * @autor Evtushenko Anton
 */

public class RunFactorial {
    static HashMap<Integer, BigInteger> cache = new HashMap<>();
    static List<Callable<BigInteger>> callables = new ArrayList<>();
    static List<String> res = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        for (int i = 0; i < 100000; i++) callables.add(() -> factorial(random.nextInt(10001)));

        System.out.println("asdasd"+ parallel(1));
        res.addAll(parallel(20));
        res.addAll(single(20));
        System.out.println("\n\n");
        System.out.println(res);
    }


    private static List<String> parallel(int q) throws InterruptedException {
        List<String> rsl = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            ExecutorService executors = Executors.newFixedThreadPool(4);
            Date date = new Date();
            HashSet<BigInteger> bigIntegers = executors.invokeAll(callables).parallelStream().map(x -> {
                try {
                    return x.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    throw new RuntimeException();
                }
            }).collect(Collectors.toCollection(HashSet::new));
            Date date3 = new Date();
            executors.shutdown();
            System.out.println(bigIntegers);
            rsl.add(String.format("It #%s. Time parallelStream: %s", i+1, date3.getTime() - date.getTime()));
        }
        return rsl;
    }

    private static List<String> single(int q) throws InterruptedException {
        List<String> rsl = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            ExecutorService executors = Executors.newFixedThreadPool(4);
            Date date = new Date();
            HashSet<BigInteger> bigIntegers = executors.invokeAll(callables).stream().map(x -> {
                try {
                    return x.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    throw new RuntimeException();
                }
            }).collect(Collectors.toCollection(HashSet::new));
            Date date3 = new Date();
            executors.shutdown();
            System.out.println(bigIntegers);
            rsl.add(String.format("It #%s. Time stream: %s", i+1, date3.getTime() - date.getTime()));
        }
        return rsl;
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