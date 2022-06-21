package com.suetham.Queue.LinkedList;

public class Queue implements IQueue {
    private Node head;
    private Node tail;
    private int size;

    public Queue() {
        size = 0;
    }

    public void enqueue(Object value) {
        Node node = new Node(value, null);

        if (head == null && tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public Object dequeue() {
        Node nodeDequeued = head;

        head = head.next;
        size--;

        return nodeDequeued;
    }

    public boolean empty() {
        return size == 0;
    }

    public void show() {
        Node node = head;

        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
    }
}
