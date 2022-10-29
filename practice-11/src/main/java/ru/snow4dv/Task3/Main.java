package ru.snow4dv.Task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double result = new Subtract(
                new Multiply(
                        new Const(2),
                        new Variable("x")
                ),
                new Const(3)
        ).evaluate(5);
        System.out.printf("Result1 = %7f\n", result);

        double x;
        Scanner s = new Scanner(System.in);
        System.out.print("Введите число: ");
        x = s.nextDouble();
        result = new Add(
                new Subtract(
                new Multiply(new Variable("x"),
                        new Variable("x")),
                        new Multiply(new Const(2), new Variable("x"))
        ),
                new Const(1)).evaluate(x);
        System.out.printf("Result2 = %7f\n", result);
    }
}

