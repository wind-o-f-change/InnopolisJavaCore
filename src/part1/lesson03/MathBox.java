package part1.lesson03;

import java.sql.Array;
import java.util.*;

/**
 * Create 25.04.2020
 *
 * @autor Evtushenko Anton
 */

public class MathBox<T extends Number> extends ObjectBox {
    private ArrayList<Number> numberList = new ArrayList<>();

    public void separator(long l){
        for (int i = 0; i < numberList.size(); i++) {
            numberList.set(i, (numberList.get(i).doubleValue()/l));
        }
    }

    public void separator(double d){
        for (int i = 0; i < numberList.size(); i++) {
            numberList.set(i, (numberList.get(i).doubleValue()/d));
        }
    }

    public double summator() {
        return numberList.stream().mapToDouble(Number::doubleValue).sum();
    }

    public MathBox(T[] numbers) {
        List<T> nums = new LinkedList<>();
        nums.addAll(Arrays.asList(numbers));

        // The loop checks the "numbers" for clones and deletes them
        int deleted = 0;
        for (int i = 0; i < nums.size(); i++) {
            Number number1 = nums.get(i);
            for (int j = 0; j < nums.size(); j++) {
                if (j == i) continue;
                Number number2 = nums.get(j);
                if ((number1.hashCode() == number2.hashCode()) & number1.equals(number2)) {
                    nums.remove(j);
                    if (i > 0) i--;
                    deleted++;
                }
            }
        }
        if (deleted > 0) System.out.printf("Всего удалено %d шт.\n", deleted);
        numberList.addAll(nums);
    }

    @Override
    public void addObject(Object objMathBox) {
        if (!(objMathBox instanceof Number)) throw new ClassCastException("Недопустимое значение");
        numberList.add((T) objMathBox);
    }

    @Override
    public void deleteObject(Object objMathBox) {
        Number number = (Number) objMathBox;
        numberList.remove(number);
    }

    @Override
    public void dump() {
        System.out.print("Content from the MathBox list : ");
        numberList.forEach(v -> System.out.print(v + " "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
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

//        sb.append("\nСумма значений коллекции равна:\n" + summator());
        return sb.toString();
    }
}