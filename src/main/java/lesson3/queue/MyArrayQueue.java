package lesson3.queue;

import java.util.Arrays;

public class MyArrayQueue<T> implements MyQueue<T> {

    protected static final int DEFAULT_TAIL = 0;
    protected static final int DEFAULT_HEAD = 0;

    protected final T[] data;
    protected int size;

    protected int tail;
    protected int head;

    public MyArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyArrayQueue(int capacity) {
        data = (T[]) new Object[capacity];
        head = DEFAULT_HEAD;
        tail = DEFAULT_TAIL;
    }

    @Override
    public boolean offer(T elem) {
        if (isFull())
            return false;

        if (tail == data.length)
            tail = DEFAULT_TAIL;

        data[tail++] = elem;
        size++;
        return true;
    }

    @Override
    public T poll() {
        if (isEmpty())
            return null;

        if (head == data.length)
            head = DEFAULT_HEAD;

        size--;
        return data[head++];
    }

    @Override
    public T peek() {
        return data[head];
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

    //для тестирования
    public T[] getArray() {
        return Arrays.copyOf(data, size);
    }
}
