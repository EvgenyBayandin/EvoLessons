package ru.webdev.decorator;

class EngeneerCalculator implements Calculator {

    @Override
    public double getResult(double a, double b) {
        return Math.pow(a, b);
    }

}