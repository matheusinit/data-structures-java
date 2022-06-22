package com.suetham.Queue.Array;

public class Queue implements IQueue {
    private Object[] array;
    private int head;
    private int tail;
    private int size;

    public Queue(int size) {
        array = new Object[size];
        size = 0;
        head = tail = 0;
    }

    public void enqueue(Object value) {
        array[tail] = value;
        tail++;
        size++;
    }

    public Object dequeue() throws Exception {
        if (head > tail - 1) {
            throw new Exception("There is no items dequeue");
        }
        Object dequeued = array[head];
        head++;
        size--;
        return dequeued;
    }

    public boolean empty() {
        return size == 0;
    }

    public boolean full() {
        return size == array.length;
    }

    public void show() {
        for (int i = head; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
