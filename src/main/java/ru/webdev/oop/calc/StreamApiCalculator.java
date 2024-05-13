package ru.webdev.oop.calc;

import java.util.stream.LongStream;

public class StreamApiCalculator {

    public static void main(String[] args) {
        int a = 10_000_000;
        int b = 1_000_000_000;
        long sum = getArithmeticProgressionSum(a, b);
        System.out.println("Сумма чисел между a и b, включая a и исключая b: " + sum);
    }

    public static long getArithmeticProgressionSum(int a, int b) {
        return LongStream.range(a, b)
                .sum();
    }
}