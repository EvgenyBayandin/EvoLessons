package ru.webdev.oop;

public class StudentWithTimer implements Learner {

    private Learner learner;

    public StudentWithTimer(Learner learner) {
        this.learner = learner;
    }

    @Override
    public void learn() {
        long start = System.currentTimeMillis();
        learner.learn();
        System.out.printf("Время учебы: %s ms", System.currentTimeMillis() - start);
    }
}