package ru.snow4dv;

public class InnMismatchException extends RuntimeException{

    public InnMismatchException(String message) {
        super("Incorrect individual tax number is entered, it doesnt correspond to this user: " + message);
    }

    public InnMismatchException() {
        super("Incorrect individual tax number is entered, it doesnt correspond to this user");
    }
}
