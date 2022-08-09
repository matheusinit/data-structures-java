package com.suetham;

import com.suetham.Array.Array;
import com.suetham.CircularBuffer.LinkedList.CircularBuffer;
import com.suetham.Dijkstra.Dijkstra;
import com.suetham.Graph.Aresta;
import com.suetham.Graph.Graph;
import com.suetham.Graph.Vertice;
import com.suetham.LinkedList.LinkedList;
import com.suetham.LinkedList.LinkedListWithTail;
//import com.suetham.Queue.LinkedList.Queue;
import com.suetham.Queue.Array.Queue;

import java.util.List;

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

        Vertice verticeA = new Vertice("A");
        Vertice verticeB = new Vertice("B");
        Vertice verticeC = new Vertice("C");
        Vertice verticeD = new Vertice("D");
        Vertice verticeE = new Vertice("E");
        Vertice verticeF = new Vertice("F");

        graph.inserirAresta(verticeA, verticeB, 2, true);
        graph.inserirAresta(verticeA, verticeC, 4, true);
        graph.inserirAresta(verticeB, verticeC, 3, true);
        graph.inserirAresta(verticeB, verticeE, 5, true);
        graph.inserirAresta(verticeB, verticeD, 1, false);
        graph.inserirAresta(verticeC, verticeD, 2, true);
        graph.inserirAresta(verticeD, verticeE, 1, true);
        graph.inserirAresta(verticeD, verticeF, 4, true);
        graph.inserirAresta(verticeE, verticeF, 2, true);

//        System.out.println(graph.éAdjacente(vertice, vertice));

        List<Aresta> arestas = graph.arestasIncidentes(verticeA);

        for (Aresta aresta: arestas) {
            System.out.println(aresta.getVerticeInicio() + " " + aresta.getVerticeFim());
        }

        System.out.println(graph.éAdjacente(verticeB, verticeF));

//        graph.printGraph();
    }

    public static void testDijkstra() {
        Graph graph = new Graph();

        Vertice verticeA = new Vertice("A");
        Vertice verticeB = new Vertice("B");
        Vertice verticeC = new Vertice("C");
        Vertice verticeD = new Vertice("D");
        Vertice verticeE = new Vertice("E");
        Vertice verticeF = new Vertice("F");

        graph.inserirAresta(verticeA, verticeB, 2, true);
        graph.inserirAresta(verticeA, verticeC, 4, true);
        graph.inserirAresta(verticeB, verticeC, 3, true);
        graph.inserirAresta(verticeB, verticeE, 5, true);
        graph.inserirAresta(verticeB, verticeD, 1, true);
        graph.inserirAresta(verticeC, verticeD, 2, true);
        graph.inserirAresta(verticeD, verticeE, 1, true);
        graph.inserirAresta(verticeD, verticeF, 4, true);
        graph.inserirAresta(verticeE, verticeF, 2, true);

        Dijkstra dijkstra = new Dijkstra(graph);

        dijkstra.handle(verticeA);
    }

    public static void testAStar() {
        Graph graph = new Graph();

        Vertice verticeA = new Vertice("A");
        Vertice verticeB = new Vertice("B");
        Vertice verticeC = new Vertice("C");
        Vertice verticeD = new Vertice("D");
        Vertice verticeE = new Vertice("E");
        Vertice verticeF = new Vertice("F");

        graph.inserirAresta(verticeA, verticeB, 2, true);
        graph.inserirAresta(verticeA, verticeC, 4, true);
        graph.inserirAresta(verticeB, verticeC, 3, true);
        graph.inserirAresta(verticeB, verticeE, 5, true);
        graph.inserirAresta(verticeB, verticeD, 1, true);
        graph.inserirAresta(verticeC, verticeD, 2, true);
        graph.inserirAresta(verticeD, verticeE, 1, true);
        graph.inserirAresta(verticeD, verticeF, 4, true);
        graph.inserirAresta(verticeE, verticeF, 2, true);
    }

    public static void main(String[] args) throws Exception {
//        testGraph();
        testDijkstra();
    }
}
