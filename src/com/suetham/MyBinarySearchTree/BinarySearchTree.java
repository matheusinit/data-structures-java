package com.suetham.MyBinarySearchTree;

import java.util.LinkedList;

public class BinarySearchTree {
    
    private Node root;
     
    public BinarySearchTree(Object data) {
    	root = new Node(data);
    }
    
    public boolean isExternal(Node node) {
        return node.childrenSize() == 0;
    }
    
    public boolean isInternal(Node node) {
        return node.childrenSize() > 0;
    }
    
    public boolean hasLeft(Node node) {
        return node.leftChild() != null;
    }
    
    public boolean hasRight(Node node) {
        return node.rightChild() != null;
    }
    
    public Node root() {
        return root;
    }
    
    public void insert(Object element) {
        Node parentOfNewNode = search(element, root);
        
        parentOfNewNode.addChild(element);
    }
    
    public Node search(Object key, Node node) {
        if (isExternal(node)) {
            return node;
        }
        
        Integer keyInt = (Integer) key;
        Integer nodeInt = (Integer) node.element();
        
        int compareResult = keyInt.compareTo(nodeInt);      
        
        if (compareResult < 0) {
            return search(key, node.leftChild());
        } else if (compareResult > 0 && node.rightChild() != null) {
            return search(key, node.rightChild());
        }
        
        return node;
    }
    
    public void remove(Object element) {
        Node nodeToRemove = search(element, root);
        
        int parent = (int) nodeToRemove.parent().element();
        int toRemove = (int) nodeToRemove.element();
        
        if (hasLeft(nodeToRemove) && !hasRight(nodeToRemove)) {
            if (parent >= toRemove) {
                nodeToRemove.parent().setLeftChild(nodeToRemove.leftChild());
            } else if (parent < toRemove) {
                nodeToRemove.parent().setRightChild(nodeToRemove.leftChild());
            }
        } else if (!hasLeft(nodeToRemove) && hasRight(nodeToRemove)) {
            if (parent >= toRemove) {
                nodeToRemove.parent().setLeftChild(nodeToRemove.rightChild());
            } else if (parent < toRemove) {
                nodeToRemove.parent().setRightChild(nodeToRemove.rightChild());
            }
        } else if (hasLeft(nodeToRemove) && hasRight(nodeToRemove)) {
            if (parent >= toRemove) {
                nodeToRemove.parent().setLeftChild(nodeToRemove.rightChild());
                nodeToRemove.parent().leftChild().setLeftChild(nodeToRemove.leftChild());
            } else if (parent < toRemove) {
                nodeToRemove.parent().setRightChild(nodeToRemove.rightChild());
                nodeToRemove.parent().rightChild().setLeftChild(nodeToRemove.leftChild());
            }
            
            nodeToRemove.setRightChild(null);
        } else {
            if (parent >= toRemove) {
                nodeToRemove.parent().setLeftChild(null);
            } else if (parent < toRemove) {
                nodeToRemove.parent().setRightChild(null);
            }
        }        
    }

    public void inOrder(Node node) {
        if (node.leftChild() != null) {
            inOrder(node.leftChild());
        }
        
        System.out.println(node.element());
        node.printStatus();
        
        if (node.rightChild() != null) {
            inOrder(node.rightChild());
        }
    }

    public int depth(Node node) {
        if (node.parent() == null) {
            return 0;
        }

        return 1 + depth(node.parent());
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }

        if (isExternal(node)) {
            return 0;
        }

        return 1 + Math.max(height(node.leftChild()), height(node.rightChild()));
    }

    private void printSpace(double n, Node removed) {
        for (; n > 0; n--) {
            System.out.print("\t");
        }

        if (removed == null) {
            System.out.print(" ");
        } else {
            System.out.print(removed.element());
        }
    }

    public void printTree(Node node) {
        LinkedList<Node> treeLevel = new LinkedList<Node>();
        treeLevel.add(node);

        LinkedList<Node> temp = new LinkedList<Node>();

        int counter = 0;
        int height = height(node);

        double numberOfElements = (Math.pow(2, (height + 1)) - 1);

        while (counter <= height) {
            Node removed = treeLevel.removeFirst();

            if (temp.isEmpty()) {
                printSpace(numberOfElements / Math.pow(2, counter + 1), removed);
            } else {
                printSpace(numberOfElements / Math.pow(2, counter), removed);
            }

            if (removed == null) {
                temp.add(null);
                temp.add(null);
            } else {
                temp.add(removed.leftChild());
                temp.add(removed.rightChild());
            }

            if (treeLevel.isEmpty()) {
                System.out.println("");
                System.out.println("");
                treeLevel = temp;
                temp = new LinkedList<>();
                counter++;
            }
        }
    }
}
