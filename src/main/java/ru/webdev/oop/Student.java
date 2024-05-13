package ru.webdev.oop;

import java.util.stream.IntStream;

public class Student implements Learner {
    private String name;
    private int age;
    private int group;

    @Override
    public void learn() {
        System.out.println("Я учусь. .zZ");
        IntStream.range(0, 1000000).forEach(i -> Math.log(i));
        System.out.println("Я закончил учиться");
    }
}