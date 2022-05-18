package com.suetham.MyBinarySearchTree;

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
}
