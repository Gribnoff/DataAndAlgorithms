package lesson3;

import general.MyCollection;

import java.util.Arrays;

public class MyStack<T> implements MyCollection {

    private final T[] data;
    private int size;

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyStack(int capacity) {
        this.data = (T[]) new Object[capacity];
    }

    boolean push(T elem){
        if (isFull())
            return false;

        data[size++] = elem;
        return true;
    }

    T pop() {
        return isEmpty() ? null : data[--size];
    }

    T peek() {
        return isEmpty() ? null : data[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    T[] getArray() {
        return Arrays.copyOf(data, size);
    }
}
