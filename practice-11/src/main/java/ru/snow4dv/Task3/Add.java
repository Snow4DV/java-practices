package ru.snow4dv.Task3;

public class Add implements Expression {

    private final Expression value1;
    private final Expression value2;

    public Add(Expression value1, Expression value2) {
        this.value1 = value1;
        this.value2 = value2;
    }



    @Override
    public double evaluate(double argument) {
        return value1.evaluate(argument) + value2.evaluate(argument);
    }
}
