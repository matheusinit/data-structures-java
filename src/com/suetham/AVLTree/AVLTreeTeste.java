package com.suetham.AVLTree;

public class AVLTreeTeste {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(6);
        tree.insert(3);
        tree.insert(12);
        tree.insert(10);
        tree.insert(11);
        tree.insert(4);
        tree.insert(9);
//        tree.updateBalanceFactor(tree.search(12, tree.root()));
//        System.out.println(tree.search(25, tree.root()).parent().rightChild().element());

        tree.show(tree.root());

//        System.out.println();
//        System.out.println("Height: " + tree.height(tree.root()));
//        Node node = tree.search(25, tree.root());
//        System.out.println("Node 25: " + node.element());
    }
}
