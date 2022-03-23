package com.suetham.Array;

import java.util.ArrayList;

public class Array implements IArray {
    private Object[] array;
    private int size;

    public Array(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize(int new_capacity) {
        Object[] newArray = new Object[new_capacity];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    private void moveToRight(int index) {
        for (int i = size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
    }

    private void moveToLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
    }

    public int find(Object item) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (item == this.array[i]) {
                index = i;
            }
        }
        return index;
    }

    public Object at(int index) {
        return this.array[index];
    }

    public void push(Object item) {
        if (this.size == this.capacity()) {
            this.resize(this.size * 2);
        }
        this.array[size++] = item;
    }

    public void insert(int index, Object item) {
        if (this.size == this.capacity()) {
            this.resize(this.size * 2);
        }
        this.moveToRight(index);
        this.array[index] = item;
        size++;
    }

    public void prepend(Object item) {
        if (this.size == this.capacity()) {
            this.resize(this.size * 2);
        }
        moveToRight(0);
        this.array[0] = item;
        this.size++;
    }

    public Object pop() {
        if (this.size <= this.capacity() / 4) {
            this.resize(this.capacity() / 2);
        }
        return this.array[--this.size];
    }

    public void delete(int index) {
        if (this.size <= this.capacity() / 4) {
            this.resize(this.capacity() / 2);
        }
        this.moveToLeft(index);
        this.size--;
    }

    public void remove(Object item) {
        if (this.size <= this.capacity() / 4) {
            this.resize(this.capacity() / 2);
        }

        ArrayList<Object> toKeep = new ArrayList<Object>();
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] != item) {
                toKeep.add(this.array[i]);
            }
        }

        for (int i = 0; i < toKeep.size(); i++) {
            this.array[i] = toKeep.get(i);
        }

        this.size = toKeep.size();
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.array.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print() {
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
        System.out.println("Size: " + this.size);
        System.out.println("Capacity: " + this.capacity());
    }
}
