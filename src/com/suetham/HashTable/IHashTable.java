package com.suetham.HashTable;

public interface IHashTable {
    int hash(Object key, int tableSize);
    void add(Object key, Object value);
    boolean exists(Object key);
    Object get(Object key);
    Object remove(Object key);
}
