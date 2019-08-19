package lesson4.linkedlist;

import lesson3.queue.MyQueue;

public class MyLinkedQueue<T> implements MyQueue<T> {
    private MyTwoSideLinkedList<T> data;

    public MyLinkedQueue(MyTwoSideLinkedList data) {
        this.data = new MyTwoSideLinkedList<>();
    }

    @Override
    public boolean offer(T elem) {
        data.addLast(elem);
        return true;
    }

    @Override
    public T poll() {
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
