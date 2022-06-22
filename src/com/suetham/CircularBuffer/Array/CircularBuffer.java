package com.suetham.CircularBuffer.Array;

public class CircularBuffer implements ICircularBuffer {

    private Object[] array;
    private int head;
    private int tail;
    private int size;

    public CircularBuffer(int initialLength) {
        array = new Object[initialLength];
        size = 0;
        head = tail = initialLength / 2;
    }

    public void enqueue(Object value) throws Exception {
        if (head == tail && array.length == size) {
            throw new Exception("The buffer is full");
        }

        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
    }

    public Object dequeue() throws Exception {
        Object dequeued = array[head];
        head = (head + 1) % array.length;
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
        int counter = 0;
        int index = head;

        while (counter < size) {
            System.out.print(array[index] + " ");
            index = (index + 1) % array.length;
            counter++;
        }

        System.out.println();
    }
}
