package ru.netology.patterns.homework02.task1;

public class IntsCalculator implements Ints {

    protected final Calculator target;

    public IntsCalculator(Calculator target) {
        this.target = target;
    }

    @Override
    public int sum(int arg0, int arg1) {
        return calculation(arg0, arg1, Calculator.Operation.SUM);
    }

    @Override
    public int mult(int arg0, int arg1) {
        return calculation(arg0, arg1, Calculator.Operation.MULT);
    }

    @Override
    public int pow(int a, int b) {
        return calculation(a, b, Calculator.Operation.POW);
    }

    private int calculation(int num1, int num2, Calculator.Operation operation) {
        return (int) target.newFormula()
                .addOperand(num1)
                .addOperand(num2)
                .calculate(operation)
                .result();
    }
}