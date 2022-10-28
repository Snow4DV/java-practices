package ru.snow4dv;

import java.util.StringJoiner;

public class Shirt {
    private String productCode;
    private String name;
    private String size;

    public Shirt(String productCode, String name, String size) {
        this.productCode = productCode;
        this.name = name;
        this.size = size;
    }

    public Shirt(String description) {
        String[] fields = description.split(",");
        this.productCode = fields[0];
        this.name = fields[1];
        this.size = fields[2];
    }
}
