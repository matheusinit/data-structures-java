package com.suetham.AVLTree;

public class Node {
    private Object element;
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private int balanceFactor;

    public Node(Object element) {
        this.element = element;
    }

    public Node(Object element, Node parent) {
        this.element = element;
        this.parent = parent;
    }

    public Node(Object element, Node leftChild, Node rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(Object element, Node parent, Node rightChild, Node leftChild) {
        this.element = element;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Object element() {
        return this.element;
    }

    public Node parent() {
        return this.parent;
    }

    public Node leftChild() {
        return this.leftChild;
    }

    public Node rightChild() {
        return this.rightChild;
    }

    public int balanceFactor() {
        return this.balanceFactor;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;

        if (leftChild != null) {
            leftChild.parent = this;
        }
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;

        if (rightChild != null) {
            rightChild.parent = this;
        }
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public int children() {
        int counter = 0;

        if (leftChild != null) {
            counter++;
        }

        if (rightChild != null) {
            counter++;
        }

        return counter;
    }

    public Node addChild(Object key) {
        Node node = new Node(key);

        Integer keyInt = (Integer) key;
        Integer nodeValueInt = (Integer) this.element;

        node.parent = this;

        if (keyInt.compareTo(nodeValueInt) >= 0) {
            this.rightChild = node;
        } else if (keyInt.compareTo(nodeValueInt) < 0) {
            this.leftChild = node;
        }

        return node;
    }
}
