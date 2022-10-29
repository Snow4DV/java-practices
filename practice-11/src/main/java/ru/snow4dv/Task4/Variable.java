package ru.snow4dv.Task4;

public class Variable implements Expression{
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
