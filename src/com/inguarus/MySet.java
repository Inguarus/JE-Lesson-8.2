package com.inguarus;

public interface MySet<T> {

    boolean add(T o);

    int size();

    boolean contains(T o);

    boolean remove(T o);

    void clear();

    String toString();

}
