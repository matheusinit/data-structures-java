package com.suetham.CircularBuffer.LinkedList;

public interface ICircularBuffer {
    void enqueue(Object value);
    Object dequeue();
    boolean empty();
}
