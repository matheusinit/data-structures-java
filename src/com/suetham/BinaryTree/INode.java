package com.suetham.BinaryTree;

public interface INode {
    Object element();
    void setElement(Object value);
    INode parent();
    INode leftChild();
    INode rightChild();
    Integer childrenNumber();
}
