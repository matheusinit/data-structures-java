package com.suetham.RedBlackTree;

import java.util.Objects;

public class Node {
    private Object element;
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private boolean isBlack;

    public Node(Object element) {
        this.element = element;
        this.isBlack = true;
    }

    public Node(Object element, Node parent) {
        this.element = element;
        this.parent = parent;
        this.isBlack = true;
    }

    public Node(Object element, Node leftChild, Node rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.isBlack = true;
    }

    public Node(Object element, Node parent, Node rightChild, Node leftChild) {
        this.element = element;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.isBlack = true;
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

    public void setBareLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setBareRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int children() {
        int counter = 0;

        if (leftChild != null && leftChild.element != null) {
            counter++;
        }

        if (rightChild != null && rightChild.element != null) {
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

        node.isBlack = false;

        return node;
    }

    public String color() {
        if (isBlack) {
            return "Black";
        }
        return "Red";
    }

    public void setColor(String color) {
        if (Objects.equals(color, "Red")) {
            if (!isBlack) {
                return;
            }

            isBlack = false;
        } else if (Objects.equals(color, "Black")) {
            if (isBlack) {
                return;
            }

            isBlack = true;
        }
    }
}
