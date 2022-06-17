package com.suetham.RedBlackTree;

public class RedBlackTreeTeste {
    public static void main(String[] args) {
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
}
