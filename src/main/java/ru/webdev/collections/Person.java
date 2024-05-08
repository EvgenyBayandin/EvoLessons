package ru.webdev.collections;

import java.time.LocalDate;

public class Person {
    String name;
    String surname;
    String lastname;
    LocalDate birthDay;

    public Person(String name, String surname, String lastname, LocalDate birthDay) {
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + lastname + " " + birthDay;
    }
}
