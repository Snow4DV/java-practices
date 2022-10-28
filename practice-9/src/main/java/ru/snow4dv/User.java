package ru.snow4dv;

import java.util.Objects;

public class User {
    private String fio;
    private long inn;

    public User(String fio, long inn) {
        this.fio = fio;
        this.inn = inn;
    }

    public String getFio() {
        return fio;
    }

    public long getInn() {
        return inn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return inn == user.inn && fio.equals(user.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, inn);
    }
}
