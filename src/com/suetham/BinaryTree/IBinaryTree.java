package com.suetham.BinaryTree;

import com.suetham.Tree.ITree;

public interface IBinaryTree extends ITree {
    INode leftChild(INode node);
    INode rightChild(INode node);
    boolean hasLeft(INode node);
    boolean hasRight(INode node);
}
