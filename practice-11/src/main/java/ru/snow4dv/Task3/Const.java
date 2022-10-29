package ru.snow4dv.Task3;

public class Const implements Expression {

    private double value;

    public double getValue() {
        return value;
    }

    public Const(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }


    @Override
    public double evaluate(double argument) {
        return value;
    }
}
