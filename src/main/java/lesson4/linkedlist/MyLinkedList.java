package lesson4.linkedlist;

import general.MyCollection;

public interface MyLinkedList<T> extends MyCollection {
    void addFirst(T elem);

    T removeFirst();

    boolean remove(T elem);

    boolean contains(T elem);

    T getFirst();

    void print();

    @Override
    default boolean isFull() {
        return false;
    }



    class Node<T> {
        protected final T elem;
        protected Node<T> next;

        Node(T elem) {
            this.elem = elem;
        }
    }
}
