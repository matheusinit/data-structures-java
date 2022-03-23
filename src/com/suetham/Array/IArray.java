package com.suetham.Array;

public interface IArray {
    public int size();
    public int capacity();
    public boolean isEmpty();
    public Object at(int index);
    public void push(Object item);
    public void insert(int index, Object item);
    public void prepend(Object item);
    public Object pop();
    public void delete(int index);
    public void remove(Object item);
    public int find(Object item);
}
