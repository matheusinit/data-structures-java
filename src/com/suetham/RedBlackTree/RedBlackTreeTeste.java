package com.suetham.RedBlackTree;

public class RedBlackTreeTeste {
    public static void main(String[] args) {
        testSit33Espelhado();
    }

    public static void test1() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(10);
        tree.insert(22);
        tree.insert(6);
        tree.insert(3);
        tree.insert(2);


        tree.insert(8);
//        tree.insert(7);
        tree.insert(9);

        tree.insert(30);
        tree.insert(25);

        tree.insert(15);
        tree.insert(20);

        tree.remove(3);
//        tree.remove(25);

        tree.show(tree.root());
    }

    public static void test2() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(7);
        tree.insert(9);
        tree.insert(5);
        tree.insert(8);
        tree.insert(10);


        Node node = tree.search(9, tree.root());
        node.setColor("Red");

        node = tree.search(8, tree.root());
        node.setColor("Black");

        node = tree.search(10, tree.root());
        node.setColor("Black");

        tree.show(tree.root());
    }

    public static void testSit1() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(7);
        tree.insert(2);
        tree.insert(12);
        tree.insert(1);
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        tree.insert(4);

        tree.remove(2);

        tree.show(tree.root());
    }

    public static void testSit2() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(7);
        tree.insert(2);
        tree.insert(12);
        tree.insert(1);
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);

        tree.remove(2);

        tree.show(tree.root());
    }

    public static void testSit31() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(7);
        tree.insert(6);
        tree.insert(9);
        tree.insert(5);
        tree.insert(8);
        tree.insert(10);

        Node node;

        node = tree.search(5, tree.root());
        node.setColor("Black");

        node = tree.search(9, tree.root());
        node.setColor("Red");

        node = tree.search(8, tree.root());
        node.setColor("Black");

        node = tree.search(10, tree.root());
        node.setColor("Black");

        tree.remove(6);

        tree.show(tree.root());
    }

    public static void testSit31Espelhado() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(8);
        tree.insert(6);
        tree.insert(9);
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);

        Node node;

        node = tree.search(10, tree.root());
        node.setColor("Black");
//
        node = tree.search(5, tree.root());
        node.setColor("Black");
//
        node = tree.search(7, tree.root());
        node.setColor("Black");
//
        node = tree.search(6, tree.root());
        node.setColor("Red");

        tree.remove(9);

        tree.show(tree.root());
    }

    public static void testSit32b() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(7);
        tree.insert(6);
        tree.insert(9);
        tree.insert(5);
        tree.insert(8);
        tree.insert(10);

        Node node;

        node = tree.search(8, tree.root());
        node.setColor("Black");

        node = tree.search(10, tree.root());
        node.setColor("Black");

        node = tree.search(5, tree.root());
        node.setColor("Black");

        node = tree.search(7, tree.root());
        node.setColor("Red");

//        tree.remove(6);

        tree.show(tree.root());
    }

    public static void testSit32a() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(7);
        tree.insert(6);
        tree.insert(9);
        tree.insert(5);
        tree.insert(8);
        tree.insert(10);

        Node node;

        node = tree.search(8, tree.root());
        node.setColor("Black");

        node = tree.search(10, tree.root());
        node.setColor("Black");
//
        node = tree.search(5, tree.root());
        node.setColor("Black");

        tree.remove(6);

        tree.show(tree.root());
    }

    public static void testSit33() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(7);
        tree.insert(6);
        tree.insert(9);
        tree.insert(5);
        tree.insert(8);
        tree.insert(10);

        Node node;

        node = tree.search(5, tree.root());
        node.setColor("Black");
//
        node = tree.search(10, tree.root());
        node.setColor("Black");
////
//        node = tree.search(5, tree.root());
//        node.setColor("Black");
//
        tree.remove(6);

        tree.show(tree.root());
    }

    public static void testSit33Espelhado() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(8);
        tree.insert(6);
        tree.insert(9);
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);

        Node node;

        node = tree.search(5, tree.root());
        node.setColor("Black");
//
        node = tree.search(10, tree.root());
        node.setColor("Black");
////
//        node = tree.search(5, tree.root());
//        node.setColor("Black");
//
        tree.remove(9);

        tree.show(tree.root());
    }
}
