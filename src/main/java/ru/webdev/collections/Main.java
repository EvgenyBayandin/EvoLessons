package ru.webdev.collections;

public class Main {

    /*
    Этот метод демонстрирует проблему при работе с нетипизированным динамическим массивом, когда не известно заранее какой тип данных содержит/поступает в массив.

    Для решения проблемы в Java 5 принят способ параметризации типов <>. Это позволяет избежать проблемы при работе с динамическим массивом. В Java 7 это реализовано с помощью интерфейса Dynamic.
    */

    public static void main(String[] args) {

        ArrayDynamic<String> arrayDynamic = new ArrayDynamic<String>();
//        arrayDynamic.add(2);
//        arrayDynamic.add(3);
        arrayDynamic.add("any text");
        arrayDynamic.add("demo text");
//        arrayDynamic.remove(0);
//        System.out.println(((String) arrayDynamic.get(1)).length()); // 8 - это длина строки, но если обратимся по индексу 2, то получим исключение ClassCastException
        System.out.println(arrayDynamic);
        System.out.println(arrayDynamic.get(1).length());
    }
}
