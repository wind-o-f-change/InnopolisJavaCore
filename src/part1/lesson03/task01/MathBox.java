package part1.lesson03.task01;

import part1.lesson02.task01.MainErrExceptions;
import part1.lesson02.task03.Person;

import java.util.*;

/**
 * Create 25.04.2020
 *
 * @autor Evtushenko Anton
 */

public class MathBox implements Iterator {
    List<Number> numberList = new ArrayList<>();



    public double summator() {
        double d = 0;

        for (int i = 0; i < numberList.size(); i++) {
            Number number = numberList.get(i);
//           if (number)d += numberList.get(i).doubleValue();//Double.parseDouble(numberList.get(i).toString());
        }

        return d;
    }

    public static void main(String[] args) {
//        Number[] numbers = new Number[100];
//        Random random = new Random();
//        for (int i = 0; i < numbers.length; i++) {
//            if (i % 35 == 0) numbers[i] = random.nextLong();
//            else if (i % 10 == 0) numbers[i] = random.nextDouble();
//            else if (i % 6 == 0) numbers[i] = random.nextFloat();
//            else numbers[i] = random.nextInt(50);
//
//        }
//        System.out.println(new MathBox(numbers));
        System.out.println();
    }

    public MathBox(Number[] numbers) {
        List<Number> numberList = new LinkedList<>();
        numberList.addAll(Arrays.asList(numbers));

        // The loop checks the "numbers" for clones and deletes them
        int deleted = 0;
        for (int i = 0; i < numberList.size(); i++) {
            Number number1 = numberList.get(i);
            for (int j = 0; j < numberList.size(); j++) {
                if (j == i) continue;
                Number number2 = numberList.get(j);
                if ((number1.hashCode() == number2.hashCode()) & number1.equals(number2)) {
                    numberList.remove(j);
                    if (i > 0) i--;
                    deleted++;
//                    System.out.println("Удалено повторное значение");
                }
            }
        }
        if (deleted > 0) System.out.printf("Всего удалено %d шт.\n", deleted);
        this.numberList.addAll(numberList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return numberList.equals(mathBox.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("This is MathBox class\n");

        for (int i = 0; i < numberList.size(); i++) {
            sb.append(numberList.get(i)).append(" ");
            if ((i + 1) % 25 == 0) sb.append("\n");
        }

        sb.append("\nСумма значений коллекции равна:\n" + summator());
        return sb.toString();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
