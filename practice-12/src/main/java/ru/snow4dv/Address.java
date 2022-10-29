package ru.snow4dv;

import java.util.StringTokenizer;

public class Address {
    private String country, region, city, street, house, building, flat;

    public Address(String address, String delimeter) {
        StringTokenizer tokenizer = new StringTokenizer(address);
        country = tokenizer.nextToken(delimeter);
        region = tokenizer.nextToken(delimeter);
        city = tokenizer.nextToken(delimeter);
        street = tokenizer.nextToken(delimeter);
        house = tokenizer.nextToken(delimeter);
        building = tokenizer.nextToken(delimeter);
        flat = tokenizer.nextToken(delimeter);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", building='" + building + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }
}
