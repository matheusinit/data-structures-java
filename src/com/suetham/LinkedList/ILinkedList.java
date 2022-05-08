package com.suetham.LinkedList;

public interface ILinkedList {
    int size();
    boolean empty();
    Object valueAt(int index);
    void pushFront(Object item);
    Object popFront();
    void pushBack(Object item);
    Object popBack();
    Object front();
    Object back();
    void insert(int index, Object item);
    Object erase(int index);
    Object valueNFromEnd(int n);
    void reverse();
    int removeValue(Object item);
}
