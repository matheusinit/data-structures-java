package com.suetham.RedBlackTree;

import java.util.LinkedList;

public class RedBlackTree {
    private Node root;
    private Node leaf;

    public RedBlackTree() {
        this.leaf = new Node(null);
        this.leaf.setColor("Black");
    }

    public Node root() {
        return this.root;
    }

    public boolean isExternal(Node node) {
        return node.children() == 0;
    }

    public boolean isInternal(Node node) {
        return node.children() > 0;
    }

    public boolean hasLeft(Node node) {
        return node.leftChild() != null && node.leftChild().element() != null;
    }

    public boolean hasRight(Node node) {
        return node.rightChild() != null && node.rightChild().element() != null;
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }

        if (isExternal(node)) {
            return 0;
        }

        return Math.max(height(node.leftChild()), height(node.rightChild())) + 1;
    }

    public int depth(Node node) {
        if (node.parent() == null) {
            return 0;
        }

        return depth(node.parent()) + 1;
    }

    public Node nextInOrder(Node node) {
        if (node.parent().leftChild() == node) {
            node = node.leftChild();

            while (node.leftChild() != null) {
                node = node.leftChild();
            }

            return node;
        }
        node = node.rightChild();
        while (node.leftChild() != null) {
            node = node.leftChild();
        }

        return node;
    }

    public void insert(Object key) {
        Node parentOfNewNode = search(key, this.root);
        Node node;

        if (parentOfNewNode == null) {
            node = this.root = new Node(key);
        } else {
            node = parentOfNewNode.addChild(key);
        }

        node.setBareLeftChild(leaf);
        node.setBareRightChild(leaf);

        fixTree(node);
    }

    private void fixTree(Node node) {
        if (node.parent() == null) {
            return;
        }
        if (node.parent().color() == "Black") {
            return;
        } else if (node.parent().color() == "Red") {
            Node uncle = node.parent().parent().leftChild();
            Node grandparent = node.parent().parent();

            if (grandparent.leftChild() == node.parent()) {
                uncle = node.parent().parent().rightChild();
            } else if (grandparent.rightChild() == node.parent()) {
                uncle = node.parent().parent().leftChild();
            }

            if (uncle.color() == "Red") {
                node.parent().setColor("Black");
                uncle.setColor("Black");

                if (grandparent.parent() != null) {
                    grandparent.setColor("Red");
                }
            } else if (uncle.color() == "Black") {
                if (node.parent().leftChild() == node && grandparent.leftChild() == node.parent()) {
                    // Rotação direita simples
                    rotateRight(grandparent);
                    grandparent.setColor("Red");
                    node.parent().setColor("Black");
                } else if (node.parent().rightChild() == node && grandparent.rightChild() == node.parent()) {
                    // Rotação esquerda simples
                    rotateLeft(grandparent);
                    grandparent.setColor("Red");
                    node.parent().setColor("Black");
                } else if (node.parent().leftChild() == node && grandparent.rightChild() == node.parent()) {
                    // Rotação esquerda dupla
                    rotateRight(node.parent());
                    rotateLeft(grandparent);
                    grandparent.setColor("Red");
                    node.setColor("Black");
                } else if (node.parent().rightChild() == node && grandparent.leftChild() == node.parent()) {
                    // Rotação direita dupla
                    rotateLeft(node.parent());
                    rotateRight(grandparent);
                    grandparent.setColor("Red");
                    node.setColor("Black");
                }
            }
        }
    }

    private void rotateLeft(Node unbalancedNode) {
        Node rightSubTree = unbalancedNode.rightChild();

        Node parentOfUnbalancedNode = unbalancedNode.parent();
        unbalancedNode.setRightChild(rightSubTree.leftChild());
        rightSubTree.setLeftChild(unbalancedNode);

        if (parentOfUnbalancedNode == null) {
            this.root = rightSubTree;
            this.root.setParent(null);
        } else {
            if (parentOfUnbalancedNode.leftChild() == unbalancedNode) {
                parentOfUnbalancedNode.setLeftChild(rightSubTree);
            } else if (parentOfUnbalancedNode.rightChild() == unbalancedNode) {
                parentOfUnbalancedNode.setRightChild(rightSubTree);
            }
        }
    }

    private void rotateRight(Node unbalancedNode) {
        Node leftSubTree = unbalancedNode.leftChild();

        Node parentOfCurrentNode = unbalancedNode.parent();

        if (parentOfCurrentNode == null) {
            this.root = leftSubTree;
            leftSubTree.setParent(null);
        } else {
            if (parentOfCurrentNode.leftChild() == unbalancedNode) {
                parentOfCurrentNode.setLeftChild(leftSubTree);
            } else if (parentOfCurrentNode.rightChild() == unbalancedNode) {
                parentOfCurrentNode.setRightChild(leftSubTree);
            }
        }

        unbalancedNode.setLeftChild(leftSubTree.rightChild());
        leftSubTree.setRightChild(unbalancedNode);
    }

    public void remove(Object key) {

    }

    private void statusNode(Node node) {
        if (node != null) {
            System.out.println("Element: " + node.element());
        } else {
            System.out.println("Element: " + null);
        }

        if (node.parent() != null) {
            System.out.println("Parent: " + node.parent().element());
        } else {
            System.out.println("Parent: " + node.parent());
        }

        if (node.leftChild() != null) {
            System.out.println("Left child: " + node.leftChild().element());
        } else {
            System.out.println("Left child: " + node.leftChild());
        }

        if (node.rightChild() != null) {
            System.out.println("Right child: " + node.rightChild().element());
        } else {
            System.out.println("Right child: " + node.rightChild());
        }
    }

    public Node search(Object key, Node node) {
        if (root == null) {
            return null;
        }

        if (isExternal(node)) {
            return node;
        }

        Integer keyInt = (Integer) key;
        Integer nodeValueInt = (Integer) node.element();

        if (keyInt.compareTo(nodeValueInt) > 0) {
            if (hasRight(node)) {
                return search(key, node.rightChild());
            }

            return node;
        } else if (keyInt.compareTo(nodeValueInt) < 0) {
            if (hasLeft(node)) {
                return search(key, node.leftChild());
            }

            return node;
        }

        return node;
    }

    private void printSpace(double n, Node node) {
        for (; n > 0; n--) {
            System.out.print("    ");
        }

        if (node == null) {
            System.out.print(" ");
        } else {
            if (node.element() == null) {
                System.out.print("N<" + node.color().charAt(0) + ">");
            } else {
                System.out.print(node.element() + "<" + node.color().charAt(0) + ">");
            }
        }
    }

    public void show(Node node) {
        LinkedList<Node> level = new LinkedList<>();
        level.add(node);

        LinkedList<Node> temp = new LinkedList<>();

        int height = height(node);
        int counter = 0;

        double numberOfElements = Math.pow(2, height + 1) - 1;

        while (counter <= height) {
            Node current = level.removeFirst();

            if (temp.isEmpty()) {
                printSpace(numberOfElements / Math.pow(2, counter + 1), current);
            } else {
                printSpace(numberOfElements / Math.pow(2, counter), current);
            }

            if (current == null) {
                temp.add(null);
                temp.add(null);
            } else {
                temp.add(current.leftChild());
                temp.add(current.rightChild());
            }

            if (level.isEmpty()) {
                System.out.println("");
                System.out.println("");
                level = temp;
                temp = new LinkedList<>();
                counter++;
            }
        }
    }
}
