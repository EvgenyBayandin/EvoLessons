package ru.webdev.lambda;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Examples {

    // функциональный интерфейс
    interface Operation {
        double result(double a, double b);
    }

    public static void main(String[] args) {

        // использование Лямбда-выражений
        Operation add = (a, b) -> a + b;
        System.out.println(add.result(10, 20)); // 10 + 20 = 30.0;

        calc(3, 7, (a, b) -> a + b); // 3 + 7 = 10.0;


        // Работа с коллекциями
        List<String> lines = List.of("zzz", "bbb", "sss", "ddd");
        // выводим элементы коллекции с помощью foreach
        lines.forEach(l -> System.out.println());
        // если не производим операции над каждым элементом коллекции
        lines.forEach(System.out::println); // zzz, bbb, sss, ddd
        // если производим операции над каждым элементом коллекции
        lines.forEach(l -> System.out.println(l.toUpperCase())); // ZZZ, BBB, SSS, DDD


        // Работа с Stream API
        // старый синтаксис с циклом for
        List<Integer> numbers = List.of(1, 2, 3);
        for(int i : numbers){
            System.out.println(i); // 1, 2, 3
        }
        // новый синтаксис с циклом for с использованием Stream API
        IntStream.of(2, -7, 16, -34, 0, 65, -6) // создаем поток
                .filter(n -> n < 0) // фильтруем поток
                .forEach(System.out::println); // -7, -34, -6 терминальная операция

        /*
        Кроме IntStream, существуют LongStream и DoubleSteram для работы с числами, а также параметризованный тип Stream<>, для работы с другими типами данных.
Также есть и другие промежуточные операции кроме filter, например, skip(n) - пропускает n элементов в потоке, limit(n) - ограничивает количество символов значением n, map - преобразует тип поступающих в данных в нужный нам тип, flatMap - для получения нескольких объектов из одного.
         */





        class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;

            }


    }


        // создаем поток
        Stream.of(
                new Person("Ivan", 25),
                new Person("Petr", 30),
                new Person("Sidor", 45)
        )

        //преобразуем поток в другой тип
                .map(p -> p.getAge())
                // получаем жва объхекта из одного
                .flatMap(age -> Stream.of(String.format("Age: %s", age),
                        String.format("Year of birth: %s", LocalDate.now().getYear() - age)))
                // выводим результат
                .forEach(System.out::println); // Age: 25 Year of birth: 1999 Age: 30 Year of birth: 1994 Age: 45 Year of birth: 1979



        /*
        Терминальные операции

count() - Аналог метода size() в коллекциях. min() возвращает минимальное значение, а max()  - максимальное. В качестве параметра они принимают Comparator. findFirst() возвращает первый элемент стрима. Этот метод очень удобно использовать в паре с filter(). Чтобы проверить все элементы стрима на соответствие некоторому условию, используйте метод allMatch(). Его результатом может быть только true или false. Если нужно проверить, что ни один элемент не удовлетворяет условию, воспользуйтесь методом noneMatch(). Чтобы проверить наличие хотя бы одного элемента, удовлетворяющего условию, используйте метод anyMatch().
        */

        List<Person> people = List.of(
                new Person("Vasya", 30),
                new Person("Fedya", 25),
                new Person("Misha", 18),
                new Person("Okopiy", 99),
                new Person("Slava", 13)
        );

        System.out.println("Age > 50?");
        Predicate<Person> predicate = p -> p.getAge() > 50;
        System.out.println("anyMatch: " + people.stream().anyMatch(predicate)); // true
        System.out.println("allMatch: " + people.stream().allMatch(predicate)); // false
        System.out.println("noneMatch: " + people.stream().noneMatch(predicate)); // false

        System.out.println("Max age?");
        System.out.println(people.stream().mapToInt(p -> p.getAge()).max().getAsInt()); // 99

        // приведение потока к коллекции
        Stream<Person> peopleCollection = Stream.of(
                new Person("Vasy", 30),
                new Person("Fedya", 25),
                new Person("Misha", 18),
                new Person("Okopiy", 99),
                new Person("Slava", 13)
        );
        Set<String> personList = peopleCollection.map(p -> p.getName())
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(personList); // [Fedya, Misha, Okopiy, Slava, Vasy]

    }






// создаем свой интерфес для вычислений
//    public static void calc(double a, double b, Operation operation) {
//        System.out.println(operation.result(a, b)); // 3 + 7 = 10.0;
//    }
// заменим на готовый интерфейс для вычислений BinaryOperator<Double> из библиотеки java.util.function
public static void calc(double a, double b, BinaryOperator<Double> operation) {
    System.out.println(operation.apply(a, b)); // 3 + 7 = 10.0;
}

}



