package com.suetham.LinkedList;

public class LinkedListWithTail implements ILinkedList {
    Node head;
    Node tail;
    int size;

    public LinkedListWithTail() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public Object valueAt(int index) {
        Node node = head;

        for (int i = 0; i < size; i++) {
            if (i == index) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    public void pushFront(Object item) {
        if (head == null && tail == null) {
            head = tail = new Node(item, null);
        } else if (head == null) {
            head = new Node(item, null);
        } else if (tail == null) {
            tail = new Node(item, null);
        }

        head = new Node(item, head);
        size++;
    }

    public Object popFront() {
        Object item = head;
        head = head.next;
        size--;
        return item;
    }

    public void pushBack(Object item) {
        if (head == null && tail == null) {
            head = tail = new Node(item, null);
            size++;
            return;
        }

        tail.next = new Node(item, null);
        size++;
    }

    public Object popBack() {
        Node node = head;

        while (node.next.next != null) {
            node = node.next;
        }

        Object item = node.next;
        node.next = null;
        size--;
        return item;
    }

    public Object front() {
        return head;
    }

    public Object back() {
        return tail;
    }

    public void insert(int index, Object item) {
        Node node = head;
        int count = 0;

        Node pastNode = null;

        while (node.next != null) {
            if (count == index) {
                Node newNode = new Node(item, node);
                if (index > 0) {
                    pastNode.next = newNode;
                }
            }

            pastNode = node;
            node = node.next;
            count++;
        }
        size++;
    }

    public Object erase(int index) {
        Node node = head;
        int count = 0;

        Node pastNode = null;
        while (node.next != null) {
            if (count == index) {
                if (pastNode != null) {
                    pastNode.next = node.next;
                } else {
                    head = head.next;
                }

                break;
            }

            pastNode = node;
            node = node.next;
            count++;
        }
        size--;

        return node;
    }

    public Object valueNFromEnd(int n) {
        Node node = head;
        Object item = null;
        int index = size - 1 - n;
        int count = 0;

        while (node != null) {
            if (index == count) {
                item = node;
            }

            node = node.next;
            count++;
        }

        return item;
    }

    public void reverse() {
        Node node = head;

        Node pastNode = null;

        while (node != null) {
            pastNode = new Node(node.item, pastNode);
            node = node.next;
        }

        head = pastNode;
    }

    public int removeValue(Object item) {
        Node node = head;
        int index = 0;

        Node pastNode = null;

        while (node.next != null) {
            if (node.item == item) {
                if (node == head) {
                    head = node.next;
                } else {
                    pastNode.next = node.next;
                }
            }
            pastNode = node;
            node = node.next;
            index++;
        }
        size--;
        return index;
    }
}
