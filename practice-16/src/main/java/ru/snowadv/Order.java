package ru.snowadv;

public class Order {
    private final ItemsLinkedList<Item> itemsLinkedList = new ItemsLinkedList<>();

    public void Add(Item purchase) {
        itemsLinkedList.pushBack(purchase);
    }

    public void Remove(Item purchase) {
        itemsLinkedList.remove(purchase);
    }

    public Item get(int index) {
        return itemsLinkedList.get(index);
    }

}
