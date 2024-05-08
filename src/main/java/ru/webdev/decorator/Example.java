package ru.webdev.decorator;

public class Example {

    public static void main(String[] args) {
        System.out.print("result: "); // result: Время выполнения метода: 24300 ns
        System.out.println(new EngeneerCalculatorMeter(new EngeneerCalculator()).getResult(300.3, 40.4)); // 1.2394682911068347E100
    }
}