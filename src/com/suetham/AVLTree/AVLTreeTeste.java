package com.suetham.AVLTree;

public class AVLTreeTeste {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(5);
        tree.insert(25);

        tree.remove(50);


        tree.show(tree.root());
    }
}
