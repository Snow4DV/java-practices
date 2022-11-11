package ru.snowadv;

public class Main {
    public static void main(String[] args) {
        TablesOrderManager tablesOrderManager = new TablesOrderManager();

        Order firstOrder = new Order();
        firstOrder.Add(new Drink("Coke", 1.59, "Black sparkling drink"));
        firstOrder.Add(new Dish("French fries", 0.75, "Oily small long things made of potato"));
        Order secondOrder = new Order();
        firstOrder.Add(new Dish("Number 9", 1.22, "Chicken burger"));
        firstOrder.Add(new Dish("Number 9", 1.22, "Chicken burger"));
        firstOrder.Add(new Dish("Number 6 large", 1.00, "Burger with ketchup"));
        firstOrder.Add(new Dish("Number 3 with extra dip", 1.00, "Burger with bacon"));
        firstOrder.Add(new Dish("Number 4", 3.00, "Burger with cheese"));
        firstOrder.Add(new Drink("Large soda", 1.23, "Soda that big smoke likes"));

        tablesOrderManager.Add(firstOrder);
        tablesOrderManager.Add(secondOrder);
    }
}