package ru.snowadv;

public class TablesOrderManager {
    private ItemsLinkedList<Order> orders = new ItemsLinkedList<>();

    public void Add(Order order) {
        orders.pushBack(order);
    }

    public void Remove(Order order) {
        orders.remove(order);
    }

    public Order get(int index) {
        return orders.get(index);
    }
}
