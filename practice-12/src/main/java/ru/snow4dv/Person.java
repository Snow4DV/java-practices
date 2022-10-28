package ru.snow4dv;

public class Person {
    private String firstName, lastName, patronymic;

    public Person(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(lastName);
        if(firstName != null || patronymic != null) {
            builder.append(' ');
        }
        if(firstName != null) {
            builder.append(firstName.charAt(0)).append('.');
        }
        if(patronymic != null) {
            builder.append(patronymic.charAt(0)).append('.');
        }
        return builder.toString();
    }
}