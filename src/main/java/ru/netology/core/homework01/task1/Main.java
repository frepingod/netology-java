package ru.netology.core.homework01.task1;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = Calculator.instance.get();

        int plus = calculator.plus.apply(3, 5);
        calculator.println.accept("3 + 5 = " + plus);

        int minus = calculator.minus.apply(1,4);
        calculator.println.accept("1 - 4 = " + minus);

        int multiply = calculator.multiply.apply(6,7);
        calculator.println.accept("6 * 7 = " + multiply);

        try {
            int devide = calculator.devide.apply(15,3);
            calculator.println.accept("15 / 3 = " + devide);

            int devideByZero = calculator.devide.apply(5,0);
            calculator.println.accept("5 / 0 = ERROR!!!" + devideByZero);
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя!");
        }

        int pow = calculator.pow.apply(-12);
        calculator.println.accept("(-12) * (-12) = " + pow);

        int absPositive = calculator.abs.apply(5);
        calculator.println.accept("5 modulo: " + absPositive);

        int absNegative = calculator.abs.apply(-148);
        calculator.println.accept("(-148) modulo: " + absNegative);

        boolean positive = calculator.isPositive.test(111);
        calculator.println.accept("111 isPositive: " + positive);

        boolean negative = calculator.isPositive.test(-222);
        System.out.println("-222 isPositive: " + negative);
    }
}