package ru.webdev.lambda;

import ru.webdev.decorator.Calculator;

public class LambdaExample {

    public static void main(String[] args) {

        Calculator calculator = new ru.webdev.decorator.Calculator() {
            @Override
            public double getResult(double a, double b) {
                return 0;
            }
        };
        System.out.println(calculator.getResult(2,3));

        // Реализация интерфейса через анонимный класс
        calculator = new Calculator() {
            @Override
            public double getResult(double a, double b) {
                return (a + b) / 2;
            }
        };

        // лямбда выражения () -> {...}
        // если у интерфейса один метод, такой интерфейс функциональный
        calculator = (a, b) -> (a + b) / 2;
        System.out.println(calculator.getResult(2,3));

        //передача в метод
        lambdaDemo((a, b) -> (a + b) / 2, 2, 3);

        //Прямые ссылки на метод ::
        /*
        ссылка на статический метод
        ссылка на метод экземпляра существующего объекта
        ссылка на метод экземпляра объекта определенного типа
        ссылка на конструктор
        */

        Calculator c = LambdaExample::LinkOnMethodDemo;
        System.out.println(c.getResult(2,3));

        Calculator pow = Math::pow;
        System.out.println(pow.getResult(2,3));

    }


    private static void lambdaDemo(Calculator calculator, double a, double b) {
        System.out.println(calculator.getResult(a, b));
    }

    private static double LinkOnMethodDemo(double a, double b) {
        return (a - b) / 2;
    }

}
