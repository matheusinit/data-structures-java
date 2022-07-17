package com.suetham;

import com.suetham.Array.Array;
import com.suetham.CircularBuffer.LinkedList.CircularBuffer;
import com.suetham.Graph.Graph;
import com.suetham.Graph.Vertice;
import com.suetham.LinkedList.LinkedList;
import com.suetham.LinkedList.LinkedListWithTail;
//import com.suetham.Queue.LinkedList.Queue;
import com.suetham.Queue.Array.Queue;

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
        list.insert(1, 3);
        list.erase(1);
        list.popFront();
        list.removeValue(3);
        list.reverse();
        System.out.println("Head: " + list.front());
        System.out.println("Tail: " + list.back());
        System.out.println("Size: " + list.size());
        System.out.println("Value at 1: " + list.valueAt(0));
        System.out.println("Value at 0 from the end: " + list.valueNFromEnd(6));

        // Linked List With Tail
        LinkedListWithTail listWTail = new LinkedListWithTail();

        listWTail.pushFront(10);

        System.out.println(listWTail.back());

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

    public static void testQueue() throws Exception {
//        Queue queue = new Queue();
//
//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        queue.enqueue(4);
//        queue.enqueue(5);
//
//        System.out.println("Removido: " + queue.dequeue());
//        System.out.println("Removido: " + queue.dequeue());
//
//        queue.show();
        Queue queue = new Queue(6);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Removido: " + queue.dequeue());
        System.out.println("Removido: " + queue.dequeue());
        System.out.println("Removido: " + queue.dequeue());
        System.out.println("Removido: " + queue.dequeue());
        System.out.println("Removido: " + queue.dequeue());
        System.out.println("Removido: " + queue.dequeue());
//        System.out.println("Removido: " + queue.dequeue());

        queue.show();
    }

    public static void testCircularBufferArray() throws Exception {
//        CircularBuffer buffer = new CircularBuffer(6);
//
//        buffer.enqueue(1);
//        buffer.enqueue(2);
//        buffer.enqueue(3);
//        buffer.enqueue(4);
//        buffer.enqueue(5);
//        buffer.enqueue(6);
//
//        System.out.println("Full: " + buffer.full());
//
//        buffer.dequeue();
//        buffer.dequeue();
//
//        buffer.enqueue(7);
//
//        buffer.dequeue();
//
//        System.out.println("Full: " + buffer.full());
//        System.out.println("Empty: " + buffer.empty());
//
//        buffer.show();

        CircularBuffer buffer = new CircularBuffer();

        System.out.println("Empty: " + buffer.empty());

        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);

        System.out.println("Removido: " + buffer.dequeue());
        System.out.println("Removido: " + buffer.dequeue());

        buffer.enqueue(4);
        buffer.enqueue(5);

        System.out.println("Removido: " + buffer.dequeue());

        System.out.println("Empty: " + buffer.empty());

        buffer.show();
    }

    public static void testGraph() {
        Graph graph = new Graph();

        Vertice vertice = new Vertice("v1");
        Vertice vertice2 = new Vertice("v2");
        Vertice vertice3 = new Vertice("v3");
        Vertice vertice4 = new Vertice("v4");
        Vertice vertice5 = new Vertice("v5");

        graph.inserirAresta(vertice, vertice2, 10);
        graph.inserirAresta(vertice3, vertice4, 20);
        graph.inserirAresta(vertice, vertice3, 5);
        graph.inserirAresta(vertice2, vertice4, 30);

        graph.removeVertice(vertice3);

//        System.out.println(graph.éAdjacente(vertice, vertice));

        graph.printGraph();
    }

    public static void main(String[] args) throws Exception {
        testGraph();
    }
}
