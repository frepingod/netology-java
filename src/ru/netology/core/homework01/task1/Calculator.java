package ru.netology.core.homework01.task1;

import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = Integer::sum;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    /*
        Вылетает ArithmeticException при делении на ноль.
        Решил проблему в Main классе, обернул код в try-catch.
     */
    BinaryOperator<Integer> devide = (x, y) -> x / y;

    UnaryOperator<Integer> pow = x -> x * x;

    /*
        Ошибки нет, все работает.
        Даже переписав тернарный оператор на if-else, idea подсказала вернуться к этому варианту.
        Но расставил скобочки для красоты и лучшего понимания.
     */
    UnaryOperator<Integer> abs = x -> (x > 0) ? x : (x * -1);

    Predicate<Integer> isPositive = x -> x > 0;

    /*
        Изменил Integer на String для более наглядного вывода в Main классе.
     */
    Consumer<String> println = System.out::println;
}