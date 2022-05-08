package com.suetham.LinkedList;

public class Node {
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.item.toString();
    }
}
