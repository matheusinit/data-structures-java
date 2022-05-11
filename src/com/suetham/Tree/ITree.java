package com.suetham.Tree;

import com.suetham.BinaryTree.INode;

import java.util.Iterator;

public interface ITree {
    Integer size();
    Integer height();
    boolean isEmpty();
    Iterator<Object> elements();
    Iterator<INode> nodes();
    INode root();
    INode parent(INode node);
    Iterator<INode> children(INode node);
    boolean isExternal(INode node);
    boolean isInternal(INode node);
    boolean isRoot(INode node);
    Integer depth(INode node);
    Object replace(INode node, Object value);
}
