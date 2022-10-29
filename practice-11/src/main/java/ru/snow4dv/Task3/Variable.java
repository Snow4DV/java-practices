package ru.snow4dv.Task3;

public class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(double argument) {
        return argument;
    }
}
