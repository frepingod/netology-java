package ru.netology.patterns.homework02.task1;

public class Calculator {

    public Formula newFormula() {
        return new Formula();
    }

    public static enum Operation {
        SUM, SUB, MULT, DIV, POW;
    }

    public static class Formula {
        protected Double a, b, result;

        protected Formula() {}

        public Formula addOperand(double operand) {
            if (a == null) {
                a = operand;
            } else if (b == null) {
                b = operand;
            } else {
                throw new IllegalStateException("Formula is full of operands");
            }
            return this;
        }

        public Formula calculate(Operation op) {
            if (a == null || b == null) {
                throw new IllegalStateException("Not enough operands!");
            }

            switch (op) {
                case SUM:
                    result = a + b;
                    break;
                case SUB:
                    result = a - b;
                    break;
                case MULT:
                    result = a * b;
                    break;
                case DIV:
                    result = a / b;
                    break;
                case POW:
                    result = Math.pow(a, b);
                    break;
            }
            return this;
        }

        public double result() {
            if (result == null) {
                throw new IllegalStateException("Formula is not computed!");
            }
            return result;
        }
    }
}