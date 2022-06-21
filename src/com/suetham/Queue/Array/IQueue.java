package com.suetham.Queue.Array;

public interface IQueue {
    void enqueue(Object value);
    Object dequeue();
    boolean empty();
    boolean full();
}
