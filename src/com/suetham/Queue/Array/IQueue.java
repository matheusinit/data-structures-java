package com.suetham.Queue.Array;

public interface IQueue {
    void enqueue(Object value);
    Object dequeue() throws Exception;
    boolean empty();
    boolean full();
}
