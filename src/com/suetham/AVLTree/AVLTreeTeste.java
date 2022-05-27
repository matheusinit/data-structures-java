package com.suetham.AVLTree;

public class AVLTreeTeste {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(50);
        tree.insert(20);
        tree.insert(80);
        tree.insert(70);
        tree.insert(90);
        tree.insert(60);
        tree.insert(75);

        tree.show(tree.root());
    }
}
