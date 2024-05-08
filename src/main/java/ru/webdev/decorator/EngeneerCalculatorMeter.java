package ru.webdev.decorator;

public class EngeneerCalculatorMeter implements Calculator {

    private Calculator calculator;

    public EngeneerCalculatorMeter(Calculator calculator) {
        this.calculator = calculator;
    }

    // расширили метод в отличии от простого инженерного калькулятора, подсчитываем время выполнения
    @Override
    public double getResult(double a, double b) {
        long startTime = System.nanoTime();
        double result = calculator.getResult(a, b); //передаем методу в калькулятор, то что возвращает конструктор
        long stopTime = System.nanoTime();
        System.out.printf("Время выполнения метода: %s ns\n", stopTime - startTime);
        return result;
    }
}