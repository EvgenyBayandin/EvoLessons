package ru.webdev.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        // источник  -> промежуточная операция -> ... промежуточная операция -> терминальная операция
        // пример использования
        {
            List<Integer> numbers = List.of(1, 4, 7, 6, 2, 9, 7, 8);
            //=======================================
            long count = 0;
            for (int number : numbers) {
                if (number > 5) {
                    count++;
                }
            }
            System.out.println(count); // 5
            //=======================================
            // здесь заменили цикл форич на stream
            count = numbers.stream()
                    .filter(number -> number > 5) // промежуточная операция - (предикат) фильтрация по условию > 5
                    .count(); // терминальная операция возвращает 5
            System.out.println(count); // 5
            //=======================================
            count = numbers.stream()
                    .skip(4) // промежуточная операция - (предикат)  пропускаем 4 элемента 1, 4, 7, 6
                    .filter(number -> number > 5) //промежуточная операция - (предикат) фильтрация по условию > 5
                    .count(); // терминальная операция, возвращаем результат: 3 элемента
        }

        // создание потоков
        {
            // Вызвать метод stream() из коллекции
            List<Integer> famousNumbers = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
            Stream<Integer> numbersStream = famousNumbers.stream();

            Set<String> usefulConcepts = Set.of("functions", "lazy", "immutability");
            Stream<String> usefulConceptsStream = usefulConcepts.stream();

            // создание из массива
            Stream<Double> doubleStream = Arrays.stream(new Double[]{1.0, 1d, 0.99, 2.0, 3.0, 4.0, 5.0});

            // используя метод of()
            Stream<String> words = Stream.of("Hello", "World", "!");
            
            // слияние потоков
            Stream<String> stream1 = Stream.of("Hello ");
            Stream<String> stream2 = Stream.of("World", "!");
            Stream<String> resultStream = Stream.concat(stream1, stream2); // Hello World!

            // создание пустых потоков
            Stream<Integer> empty1 = Stream.of();
            Stream<Integer> empty2 = Stream.empty();

            // также можно создать поток из файла или других источников
        }

        /*
        Intermediate operations

        filter() - возвращает новый поток, соответствующий предикату
        limit() - возвращает новый поток из первых n элементов
        skip() - возвращает новый поток без первых n элементов
        distinct() - возвращает новый поток из уникальных элементов, удовлетворяющих equals()
        sorted() - возвращает новый отсортированный поток
        peek() - возвращает поток без изменений, но позволяет просматривать элементы для отладки или удаления
        map() - возвращает новый поток, где преобразует элементы в другой тип

        Terminal operations

        count() - возвращает количество элементов в потоке в виде длинного значения
        max / min - возвращает максимальный / минимальный элемент в потоке в соотвествии с компаратором
        reduce() - объединяет все элементы в одно значение (агрегированное значение), например склеивает строки из потока строк в одну строку
        findFirst() - возвращает первый элемент в потоке
        findAny() - возвращает любой элемент в потоке
        findFirstOrElse() - возвращает первый элемент в потоке, если его нет, то возвращает другой элемент
        anyMatch() - возвращает true, если в потоке есть хотя бы один элемент, соответствующий предикату иначе false
        forEach() - вызывает метод для каждого элемента в потоке, напрмер печатает его в консоль
        collect() - преобразует поток в другой тип данных (например, в коллекцию)
        toArray() - преобразует поток в массив

         */
    }
}
