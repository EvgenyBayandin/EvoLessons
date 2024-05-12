package ru.webdev.lambda;
import java.util.function.*;

public class StandardFunctionalInterfaces {

    public static void main(String[] args) {

        // Functions
        {
            //Function<T, R> это универсальный интерфейс, представляющий функцию, которая принимает один аргумент типа Т и возвращает результат типа R.

            //String to Integer function
            Function<String, Integer> converter = Integer::parseInt;
            converter.apply("123"); // 123 (Integer)

            //String to int function
            ToIntFunction<String> anotherConverter = Integer::parseInt;
            anotherConverter.applyAsInt("333"); // 333 (Integer)

            //(Integer, Integer) to Integer function
            BiFunction<Integer, Integer, Integer> sumFunction = (a, b) -> a + b;
            sumFunction.apply(2, 3); // 5 (Integer)
        }

        // Operators
        {
            //каждый оператор принимает и возвращает значения одного типа
            //Long to Long multiplication
            UnaryOperator<Long> longMultiplication = value -> 100_000 * value;
            longMultiplication.apply(5L); // 500_000 (Long)

            //int to int addition
            IntUnaryOperator intAddition = value -> value + 1;
            intAddition.applyAsInt(5); // 6 (Integer)

            //int to int addition
            IntBinaryOperator intAddition2 = (a, b) -> a + b;
            intAddition2.applyAsInt(5, 10); // 15 (Integer)

            //String to String concatenation
            BinaryOperator<String> stringConcatenation = (a, b) -> a + b;
            stringConcatenation.apply("Hello ", "World!"); // "Hello World!" (String)
        }

       //Predicates
        {
            //Каждый предикат принимает один аргумент типа T и возвращает результат типа boolean. Он может быть использован для проверки условий.
            // Character to boolean predicate
            Predicate<Character> isDigit = Character::isDigit;
            isDigit.test('a'); // false

            // int to boolean predicate
            IntPredicate isEven = value -> value % 2 == 0;
            isEven.test(10); // true
        }

        //Suppliers
        {
            // Supplier не принимает никаких параметров и возвращает одно значение.
            Supplier<String> stringSupplier = () -> "Hello World!";
            stringSupplier.get(); // Hello World! (String)

            BooleanSupplier booleanSupplier = () -> true;
            booleanSupplier.getAsBoolean(); // true

            IntSupplier intSupplier = () -> 10;
            intSupplier.getAsInt(); // 10 (Integer)
        }

        //Consumers
        {
            // Consumer принимает один аргумент типа T и не возвращает никаких выходных значений.
            Consumer<String> printer = System.out::println;
            printer.accept("Hello World!"); // Hello World!
        }

    }
}
