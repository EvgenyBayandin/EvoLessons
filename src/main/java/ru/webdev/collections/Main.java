package ru.webdev.collections;

public class Main {

    /*
    Этот метод демонстрирует проблему при работе с нетипизированным динамическим массивом, когда не известно заранее какой тип данных содержит/поступает в массив
    */

    public static void main(String[] args) {

        ArrayDynamic arrayDynamic = new ArrayDynamic();
        arrayDynamic.add(2);
        arrayDynamic.add(3);
        arrayDynamic.add("any text");
        arrayDynamic.remove(0);
        System.out.println(((String) arrayDynamic.get(1)).length()); // 8 - это длина строки, но если обратимся по индексу 2, то получим исключение ClassCastException
        System.out.println(arrayDynamic);
    }
}
