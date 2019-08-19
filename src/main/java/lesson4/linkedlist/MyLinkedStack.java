package lesson4.linkedlist;

import lesson3.Stack.MyIStack;

public class MyLinkedStack<T> implements MyIStack<T> {
    private MyLinkedList<T> data;

    public MyLinkedStack(MyLinkedList<T> data) {
        this.data = new MySimpleLinkedList<>();
    }

    @Override
    public boolean push(T elem) {
        data.addFirst(elem);
        return true;
    }

    @Override
    public T pop() {
        return data.removeFirst();
    }

    @Override
    public T peek() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return data.isFull();
    }
}
