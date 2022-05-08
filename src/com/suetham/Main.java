package com.suetham;

import com.suetham.Array.Array;
import com.suetham.LinkedList.LinkedList;

public class Main {

    public static void testLinkedList() {
        LinkedList list = new LinkedList();

        list.pushFront(2);
        list.pushBack(4);
        list.pushBack(6);
        list.pushBack(8);
        list.pushBack(10);
        list.pushBack(12);
        list.pushBack(14);
//        list.insert(1, 3);
//        list.erase(1);
//        list.popFront();
//        list.removeValue(3);
        list.reverse();
        System.out.println("Head: " + list.front());
        System.out.println("Tail: " + list.back());
        System.out.println("Size: " + list.size());
        System.out.println("Value at 1: " + list.valueAt(0));
        System.out.println("Value at 0 from the end: " + list.valueNFromEnd(6));

    }

    public static void testArray() {
        Array array = new Array(16);

        array.push(2);
        array.push(4);
        array.push(8);
        array.push(16);

        array.delete(0);
//        array.prepend(4);
//
//        array.delete(1);

        array.print();
    }

    public static void main(String[] args) {
        testLinkedList();
    }
}
