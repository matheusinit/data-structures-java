package com.suetham.BinarySearchTree;

import com.suetham.BinaryTree.INode;

public class Node implements INode {
    Node parent;
    Object value;
    Node leftChild;
    Node rightChild;

    public Node(Node parent, Object value) {
        this.parent = parent;
        this.value = value;
    }

    public Object element() {
        return value;
    }

    public void setElement(Object value) {
        this.value = value;
    }

    public INode parent() {
        return this.parent;
    }

    public INode leftChild() {
        return this.leftChild;
    }

    public INode rightChild() {
        return this.rightChild;
    }

    public Integer childrenNumber() {
        int counter = 0;

        if (leftChild != null) {
            counter++;
        }

        if (rightChild != null) {
            counter++;
        }

        return counter;
    }
}
