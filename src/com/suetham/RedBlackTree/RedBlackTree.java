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
                    fixTree(grandparent);
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
   
    public Node nextInOrder(Node node) {
//        if (node.parent().leftChild() == node) {
//            node = node.rightChild();
//            
//            while (node.leftChild() != null && node.leftChild().element() != null) {
//                node = node.leftChild();
//            }
//
//            return node;
//        }
        node = node.rightChild();
        while (node.leftChild() != null && node.leftChild().element() != null) {
            node = node.leftChild();
        }

        return node;
    }
    
    public void remove(Object key) {
        Node nodeToRemove = search(key, root);
        Node nodeToRemoveInitial = nodeToRemove;
        Node successor = nodeToRemove;

        int parent = (int) nodeToRemove.parent().element();
        int toRemove = (int) nodeToRemove.element();

//        System.out.println(nextInOrder(nodeToRemove).element());
//        if (hasLeft(nodeToRemove) && hasRight(nodeToRemove)) {
//            nodeToRemove = nextInOrder(nodeToRemove);
//            nodeToRemoveInitial.setElement(nodeToRemove.element());
//        }

        if (hasLeft(nodeToRemove) && !hasRight(nodeToRemove)) {
            successor = nodeToRemove.leftChild();

            if (parent >= toRemove) {
                nodeToRemove.parent().setLeftChild(nodeToRemove.leftChild());
            } else if (parent < toRemove) {
                nodeToRemove.parent().setRightChild(nodeToRemove.leftChild());
            }
        } else if (!hasLeft(nodeToRemove) && hasRight(nodeToRemove)) {
            successor = nodeToRemove.rightChild();
            if (parent >= toRemove) {
                nodeToRemove.parent().setLeftChild(nodeToRemove.rightChild());
            } else if (parent < toRemove) {
                nodeToRemove.parent().setRightChild(nodeToRemove.rightChild());
            }
        } else if (hasLeft(nodeToRemove) && hasRight(nodeToRemove)) {
            successor = nextInOrder(nodeToRemove);

            toRemove = (int) successor.element();
            parent = (int) successor.parent().element();

            nodeToRemove.setElement(successor.element());

            if (parent >= toRemove) {
                successor.parent().setLeftChild(null);
            } else if (parent < toRemove) {
                successor.parent().setRightChild(null);
            }
        } else {
            if (parent >= toRemove) {
                nodeToRemove.parent().setLeftChild(null);
            } else if (parent < toRemove) {
                nodeToRemove.parent().setRightChild(null);
            }
        }

        System.out.println("to remove: " + nodeToRemove.element());
        System.out.println("successor: " + successor.element());

        if (nodeToRemove.color() == "Black" && successor.color() == "Black") {
            // Situação 3
            fixTreeAfterRemoval(successor);
        } else if (nodeToRemove.color() == "Red" && successor.color() == "Black") {
            // Situação 4
            successor.setColor("Red");
            fixTreeAfterRemoval(successor);
        }
    }
    
    private void fixTreeAfterRemoval(Node node) {
        Node brother = null;
        // Situação 3 e 4
        // Casos: 1, 2a, 2b, 3, 4

        if (node.parent().leftChild() == node) {
            System.out.println("Is left child");
            brother = node.parent().rightChild();
        } else if (node.parent().rightChild() == node) {
            System.out.println("Is right child");
            brother = node.parent().leftChild();
        }

        // Caso 1
        if (brother.color() == "Red" && node.parent().color() == "Black") {
            System.out.println("Caso 1");
            node.setDoubleBlack(true);

            if (node.parent().leftChild() == node) {
                rotateLeft(node.parent());
            } else if (node.parent().rightChild() == node) {
                rotateRight(node.parent());
            }

            brother.setColor("Black");
            node.parent().setColor("Red");
            fixTreeAfterRemoval(node);
        } else if (brother.color() == "Black") {
            if (node.parent().color() == "Black" && brother.leftChild().color() == "Black" && brother.rightChild().color() == "Black") {
                // caso 2a
                System.out.println("Caso 2a");
                brother.setColor("Red");
                node.setDoubleBlack(false);
                if (node.parent().parent() != null) {
                    node.parent().setDoubleBlack(true);
                    fixTreeAfterRemoval(node.parent());
                }
            } else if (node.parent().color() == "Red" && brother.leftChild().color() == "Black" && brother.rightChild().color() == "Black") {
                // caso 2b
                System.out.println("Caso 2b");
                brother.setColor("Red");
                node.parent().setColor("Black");
                node.setDoubleBlack(false);
            } else if (brother.leftChild().color() == "Red" && brother.rightChild().color() == "Black" && node.parent().leftChild() == node) {
                // caso 3
                System.out.println("Caso 3");
                String color = brother.color();
                brother.setColor(brother.leftChild().color());
                brother.leftChild().setColor(color);
                rotateRight(brother);
                fixTreeAfterRemoval(node);
            } else if (brother.leftChild().color() == "Black" && brother.rightChild().color() == "Red") {
                // caso 3 espelhado
                System.out.println("Caso 3 - espelhado");
                String color = brother.color();
                brother.setColor(brother.rightChild().color());
                brother.rightChild().setColor(color);
                rotateLeft(brother);
                fixTreeAfterRemoval(node);
            } else if (brother.rightChild().color() == "Red") {
                // caso 4
                System.out.println("Caso 4");
                String color = node.parent().color();
                rotateLeft(node.parent());
                node.setDoubleBlack(false);
                node.parent().setColor("Black");
                brother.rightChild().setColor("Black");
                brother.setColor(color);
            } else if (brother.leftChild().color() == "Red") {
                // caso 4 espelhado
                System.out.println("Caso 4 -- Espelhado");
                String color = node.parent().color();
                rotateRight(node.parent());
                node.setDoubleBlack(false);
                node.parent().setColor("Black");
                brother.leftChild().setColor("Black");
                brother.setColor(color);
            }
        }

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
                if (node.isDoubleBlack()) {
                    System.out.print(node.element() + "<D" + node.color().charAt(0) + ">");
                } else {
                    System.out.print(node.element() + "<" + node.color().charAt(0) + ">");
                }
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
