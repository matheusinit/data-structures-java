package com.suetham.AVLTree;

import java.util.LinkedList;
import java.util.Objects;

public class AVLTree {
    private Node root;

    public AVLTree() {}

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
        return node.leftChild() != null;
    }

    public boolean hasRight(Node node) {
        return node.rightChild() != null;
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

        node.setBalanceFactor(balanceFactor(node));

        updateAncestorBalanceFactor(node, "INSERT");

        rotate(node);
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

    public int balanceFactor(Node node) {
        int heightLeftTree = height(node.leftChild());
        int heightRightTree = height(node.rightChild());

        return heightLeftTree - heightRightTree;
    }

    /**
     * An operation to update the balance factor of ancestors AVL nodes.
     * Depending on if is an insertion or a delete operation, the variable
     * may change, so is need to know which type of operation is being realized.
     *
     * @param node The node to start the operation from
     * @param operation Operation to be made. INSERT to insert node operation
     *                  and REMOVE to delete node operation
     */
    public void updateAncestorBalanceFactor(Node node, String operation) {
        int determinant = 0;
        Node parent = node.parent();

        if (Objects.equals(operation, "INSERT")) {
            determinant = 1;
        } else if (Objects.equals(operation, "REMOVE")) {
            determinant = -1;
        }

        if (parent == null) {
            return;
        }

        if (parent.leftChild() == node) {
            parent.setBalanceFactor(parent.balanceFactor() + determinant);
        } else if (parent.rightChild() == node) {
            parent.setBalanceFactor(parent.balanceFactor() - determinant);
        }

        if (parent.balanceFactor() != 0 && Objects.equals(operation, "INSERT")) {
            updateAncestorBalanceFactor(parent, operation);
        }

        if (parent.balanceFactor() == 0 && Objects.equals(operation, "REMOVE")) {
            updateAncestorBalanceFactor(parent, operation);
        }
    }

    public void rotate(Node node) {
        Node currentNode = node.parent();

        while (currentNode != null) {
            int balanceFactor = currentNode.balanceFactor();

            if (balanceFactor < 2 && balanceFactor > -2) {
                currentNode = currentNode.parent();
            } else {
                if (currentNode.balanceFactor() == 2) {
                    if (currentNode.leftChild().balanceFactor() >= 0) {
                        rotateRight(currentNode);
                        updateBalanceFactorAfterRotations(currentNode.parent(), "RIGHT");
                    } else if (currentNode.leftChild().balanceFactor() < 0) {
                        rotateLeft(currentNode.leftChild());
                        updateBalanceFactorAfterRotations(currentNode.leftChild(), "LEFT");

                        rotateRight(currentNode);
                        updateBalanceFactorAfterRotations(currentNode.parent(), "RIGHT");
                    }
                } else if (currentNode.balanceFactor() == -2) {
                    if (currentNode.rightChild().balanceFactor() <= 0) {
                        rotateLeft(currentNode);
                        updateBalanceFactorAfterRotations(currentNode.parent(), "LEFT");
                    } else if (currentNode.rightChild().balanceFactor() > 0) {
                        rotateRight(currentNode.rightChild());
                        updateBalanceFactorAfterRotations(currentNode.rightChild(), "RIGHT");

                        rotateLeft(currentNode);
                        updateBalanceFactorAfterRotations(currentNode.parent(), "LEFT");
                    }
                }

                break;
            }
        }
    }

    private void rotateLeft(Node unbalancedNode) {
        Node rightSubTree = unbalancedNode.rightChild();

        Node parentOfUnbalancedNode = unbalancedNode.parent();
        unbalancedNode.setParent(rightSubTree);
        unbalancedNode.setRightChild(rightSubTree.leftChild());

        rightSubTree.setParent(parentOfUnbalancedNode);
        if (parentOfUnbalancedNode != null) {
            parentOfUnbalancedNode.setLeftChild(rightSubTree);
        } else {
            this.root = rightSubTree;
            rightSubTree.setParent(null);
        }

        rightSubTree.setLeftChild(unbalancedNode);
    }

    private void rotateRight(Node unbalancedNode) {
        Node leftSubTree = unbalancedNode.leftChild();

        Node parentOfCurrentNode = unbalancedNode.parent();

        if (parentOfCurrentNode != null) {
            parentOfCurrentNode.setRightChild(leftSubTree);
        } else {
            this.root = leftSubTree;
            leftSubTree.setParent(null);
        }

        unbalancedNode.setLeftChild(leftSubTree.rightChild());
        leftSubTree.setRightChild(unbalancedNode);
    }

    private void updateBalanceFactorAfterRotations(Node node, String rotationType) {
        if (Objects.equals(rotationType, "LEFT")) {
            int nodeBF = node.balanceFactor();
            int leftNodeBF = node.leftChild().balanceFactor();

            int leftNodeNewBF = leftNodeBF + 1 - Math.min(nodeBF, 0);
            int nodeNewBF = nodeBF + 1 + Math.max(leftNodeNewBF, 0);

            node.setBalanceFactor(nodeNewBF);
            node.leftChild().setBalanceFactor(leftNodeNewBF);
        } else if (Objects.equals(rotationType, "RIGHT")) {
            int nodeBF = node.balanceFactor();
            int rightNodeBF = node.rightChild().balanceFactor();

            int rightNodeNewBF = rightNodeBF - 1 - Math.max(nodeBF, 0);
            int nodeNewBF = nodeBF - 1 + Math.min(rightNodeNewBF, 0);

            node.setBalanceFactor(nodeNewBF);
            node.rightChild().setBalanceFactor(rightNodeNewBF);
        }
    }

    private void printSpace(double n, Node node) {
        for (; n > 0; n--) {
            System.out.print("    ");
        }

        if (node == null) {
            System.out.print(" ");
        } else {
            System.out.print(node.element() + "<" + node.balanceFactor() + ">");
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
                printSpace(numberOfElements / Math.pow(2, counter), current);
            } else {
                printSpace(numberOfElements / Math.pow(2, counter - 1), current);
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
