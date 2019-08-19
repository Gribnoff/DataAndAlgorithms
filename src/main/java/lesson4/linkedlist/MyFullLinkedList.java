package lesson4.linkedlist;

import general.MyCollection;

import java.util.Iterator;

public interface MyFullLinkedList<T> extends MyCollection, Iterable<T> {
    void addFirst(T elem);
    void addLast(T elem);

    T removeFirst();
    T removeLast();
    boolean remove(T elem);

    boolean contains(T elem);

    T getFirst();
    T getLast();

    Node<T> getFirstNode();
    Node<T> getLastNode();

    void print();

    @Override
    default boolean isFull() {
        return false;
    }

    class Node<T> {
        final T elem;
        Node<T> prev;
        Node<T> next;

        Node(T elem, Node<T> prev, Node<T> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
    }
}
