package com.suetham;

import com.suetham.Array.Array;

public class Main {

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
        testArray();
    }
}
