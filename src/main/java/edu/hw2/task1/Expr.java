package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    @SuppressWarnings("RegexpSinglelineJava")
    static void main(String[] args) {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        System.out.println(res + " = " + res.evaluate());
    }

    public record Constant(int number) implements Expr {
        @Override
        public double evaluate() {
            return number;
        }
    }

    public record Negate(int number) implements Expr {

        public Negate(Constant constant) {
            this(constant.number * -1);
        }

        @Override
        public double evaluate() {
            return number;
        }
    }

    public record Exponent(double number) implements Expr {

        public Exponent(Multiplication multiplication, int pow) {
            this(Math.pow(multiplication.number, pow));
        }

        @Override
        public double evaluate() {
            return number;
        }
    }

    public record Addition(double number) implements Expr {

        public Addition(Constant constant1, Constant constant2) {
            this(constant1.number + constant2.number);
        }

        public Addition(Exponent exponent, Constant constant) {
            this(exponent.number + constant.number);
        }

        @Override
        public double evaluate() {
            return number;
        }

        public String toString() {
            return String.valueOf(number);
        }
    }

    public record Multiplication(double number) implements Expr {

        public Multiplication(Addition addition, Negate negate) {
            this(addition.number * negate.number);
        }

        @Override
        public double evaluate() {
            return number;
        }
    }
}
