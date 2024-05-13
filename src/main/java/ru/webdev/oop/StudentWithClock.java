package ru.webdev.oop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentWithClock implements Learner {
    private Learner learner;

    public StudentWithClock(Learner learner) {
        this.learner = learner;
    }

    @Override
    public void learn() {
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss");
        learner.learn();
        System.out.printf("Текущее время: %s", currentTime.format(new Date()));
    }
}