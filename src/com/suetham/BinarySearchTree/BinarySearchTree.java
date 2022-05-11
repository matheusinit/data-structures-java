package com.suetham.BinarySearchTree;

import com.suetham.BinaryTree.IBinaryTree;
import com.suetham.BinaryTree.INode;

import java.util.Iterator;

public class BinarySearchTree implements IBinaryTree {
    Node root;
    int size;

    public BinarySearchTree(Node root) {
        this.root = root;
        this.size = 0;
    }

    public INode leftChild(INode node) {
        return node.leftChild();
    }

    public INode rightChild(INode node) {
        return node.rightChild();
    }

    public boolean hasLeft(INode node) {
        return node.leftChild() != null;
    }

    public boolean hasRight(INode node) {
        return node.rightChild() != null;
    }

    public Integer size() {
        return this.size;
    }

    public Integer height() {
        return null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterator<Object> elements() {
        return null;
    }

    public Iterator<INode> nodes() {
        return null;
    }

    public INode root() {
        return this.root;
    }

    public INode parent(INode node) {
        return node.parent();
    }

    public Iterator<INode> children(INode node) {
        return null;
    }

    public boolean isExternal(INode node) {
        return false;
    }

    public boolean isInternal(INode node) {
        return false;
    }

    public boolean isRoot(INode node) {
        return node.parent() == null;
    }

    public Integer depth(INode node) {
        return null;
    }

    public Object replace(INode node, Object value) {
        node.setElement(value);
        return node;
    }
}
