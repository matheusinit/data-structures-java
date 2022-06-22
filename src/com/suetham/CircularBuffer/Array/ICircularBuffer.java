package com.suetham.CircularBuffer.Array;

public interface ICircularBuffer {
    void enqueue(Object value) throws Exception;
    Object dequeue() throws Exception;
    boolean empty();
    boolean full();
}
