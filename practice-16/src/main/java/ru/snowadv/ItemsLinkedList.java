package ru.snowadv;

public class ItemsLinkedList<T> {
    private class Node {
        T item;
        Node prevNode;
        Node nextNode;

        public Node(T item, Node prevNode, Node nextNode) {
            this.item = item;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }

    private Node first = null;
    private Node last = null;

    public void pushFront(T order) {
        Node node = new Node(order, last, first);
        if(last == null) {
            last = node;
        }
        first.prevNode = node;
        first = node;
    }

    public void pushBack(T order) {
        Node node = new Node(order, last, first);
        if(first == null) {
            first = node;
        }
        last = node;
        last.nextNode = node;
    }

    public T getFirst() {
        if(first != null) {
            return first.item;
        }
        return null;
    }

    public T getLast() {
        if(last != null) {
            return last.item;
        }
        return null;
    }
    public T get(int index) {
        Node currentNode = first;
        for (int i = 1; i < index; i++) {
            if(currentNode == null) {
                break;
            }
            currentNode = currentNode.nextNode;
        }
        return (currentNode != null) ? currentNode.item : null;
    }

    public boolean remove(T item) {
        if(first == null) {
            return false;
        }

        if(item == first.item && first == last) { // if it's the only one left
            first = first.nextNode;
            return true;
        } else if(item == first.item) { // if it's the first one
            first = first.nextNode;
            return true;
        } else if(item == last.item) { // if it's the last one
            last = last.prevNode;
            return true;
        }  else { // if it's somewher ein the middle
            Node currentNode = first.nextNode;
            while(currentNode != first && currentNode != null) {
                if(currentNode.item == item) {
                    currentNode.prevNode.nextNode = currentNode.nextNode;
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                    return true;
                }
                currentNode = currentNode.nextNode;
            }
        }
        return false;
    }
}
