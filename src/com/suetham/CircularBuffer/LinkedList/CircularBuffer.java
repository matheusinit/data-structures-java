package com.suetham.CircularBuffer.LinkedList;

public class CircularBuffer implements  ICircularBuffer {
    private Node head;
    private Node tail;
    private int size;

    public CircularBuffer() {
        size = 0;
        tail = head = null;
    }

    public void enqueue(Object value) {
        Node node = new Node(value, null);

        if (head == null && tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        node.next = head;
        size++;
    }

    public Object dequeue() {
        Node dequeued = head;

        head = head.next;
        size--;

        return dequeued;
    }

    public boolean empty() {
        return size == 0;
    }

    public void show() {
        Node node = head;
        int counter = 0;

        while (counter < size) {
            System.out.print(node.item + " ");

            node = node.next;
            counter++;
        }

        System.out.println();
    }
}
