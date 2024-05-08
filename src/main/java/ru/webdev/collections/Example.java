package ru.webdev.collections;

import java.util.*;
import java.time.LocalDate;

public class Example {
    public static <Gender extends Enum<Gender>, WeekDays extends Enum<WeekDays>> void main(String[] args) {

        //Iterable
        Iterable<Integer> iterable = List.of(34, 56, 2, 78, -1);

        //Iterator
        Iterator<Integer> iterator = iterable.iterator();
        for (Integer integer : iterable) System.out.println(integer);
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        //Collection
        Collection collection = List.of(45, -89, 56, 34);
//        collection.add(33); // UnsupportedOperationException
        System.out.println(collection.contains(3)); //false

        //List //ArrayList //LinkedList //set, get, indexOf
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(-1);
        list.add(89);
        list.add(55);
        System.out.println(list.remove(2)); // 89
        System.out.println(list); // [2, -1, 55]
        System.out.println(list.remove(Integer.valueOf(2))); // true
        System.out.println(list); // [-1, 55]


        ListIterator<Integer> listIterator = list.listIterator(0);
//        System.out.println(listIterator.previous()); // NoSuchElementException т.к. мы запрашиваем элемент, предшествующий индексу 0
        System.out.println(listIterator.hasPrevious()); // false нет предшествующего элемента индексу 0
        System.out.println(listIterator.next()); // -1 следующий элемент списка [-1, 55]


        //Set //TreeSet //HashSet //EnumSet
        Set set = Set.of("i", "r", "w", "-1");
        System.out.println(set); // [w, i, r, -1] не гарантирует порядок элементов

        //TreeSet - сортирует по алфавиту или значению
        Set<Integer> numberSet = new TreeSet<>();
        numberSet.add(45);
        numberSet.add(-23);
        numberSet.add(99);
        numberSet.add(99); // не добавит, т.к. хранит только уникальные элементы
        System.out.println(numberSet); // [-23, 45, 99]


        EnumSet<ru.webdev.collections.WeekDays> workDays = EnumSet.of(ru.webdev.collections.WeekDays.MON, ru.webdev.collections.WeekDays.TUE, ru.webdev.collections.WeekDays.WED, ru.webdev.collections.WeekDays.THU, ru.webdev.collections.WeekDays.FRI);
        System.out.println(workDays.contains(ru.webdev.collections.WeekDays.SUN)); //false


        //constructor
        Set<String> reverse = new TreeSet<>(Comparator.reverseOrder());
        reverse.add("1");
        reverse.add("33");
        reverse.add("2");
        reverse.add("-1");
        reverse.add("c");
        reverse.add("b");
        reverse.add("a");
        System.out.println(reverse); // [c, b, a, 33, 2, 1, -1]


        //Map //HashMap //TreeMap // get, put // Set<K> keySet //Collection<V> values
        Map<String, ? super Person> personMap = new HashMap<>();
        personMap.put("one", new ru.webdev.collections.Person("Petr","Petrovich", "Petrov", LocalDate.of(2000, 1, 13)));
        personMap.put("two", new ru.webdev.collections.Person("Ivan","Ivanovich", "Ivanov", LocalDate.of(2018, 1, 13)));
        personMap.put("three", new ru.webdev.collections.Person("Olga","Olegovna", "Olgina", LocalDate.of(2001, 7, 30)));

        System.out.println(personMap);

        for (Map.Entry studentEntry : personMap.entrySet()) {
            System.out.printf("%-10s: ", studentEntry.getKey());
            System.out.println(studentEntry.getValue());
        }



        //null
        Map<Integer, String> map = new HashMap<>();
        map.put(null, "abc");

        System.out.println(map.get(null)); // abc
        map.put(null, "def");
        System.out.println(map.get(null)); // def

        map.put(null, null);
        map.put(1, null);
        System.out.println(map); //{null=null, 1=null}

        System.out.println(map.getOrDefault(null, "empty")); //null
        System.out.println(map.get(2)); //null, значение по индексу 2 не существует
        System.out.println(map.getOrDefault(2, "empty")); //empty


        // С Java 8  с null бороться можно так: Optional
        Optional<String> text = Optional.ofNullable(null);
        System.out.println(text.orElse("empty")); // empty

        //utility class Collections
        System.out.println(Collections.frequency(List.of(2,3,2,10,2,1), 2)); // 2 встречается 3 раза

    }
}


enum WeekDays {
    MON, TUE, WED, THU, FRI, SAT, SUN
}