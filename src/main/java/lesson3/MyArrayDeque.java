package lesson3;

import java.util.Arrays;

public class MyArrayDeque<T> implements MyDeque<T> {
    private static final int DEFAULT_TAIL = 0;
    private static final int DEFAULT_HEAD = 0;

    private T[] data;
    private int size;

    private int tail;
    private int head;

    public MyArrayDeque() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyArrayDeque(int capacity) {
        data = (T[]) new Object[capacity];
        head = DEFAULT_HEAD;
        tail = DEFAULT_TAIL;
    }

    @Override
    public boolean offerFirst(T elem) {
        if (isFull())
            return false;

        if (head == 0)
            head = data.length;

        data[--head] = elem;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(T elem) {
        if (isFull())
            return false;

        if (tail == data.length)
            tail = DEFAULT_TAIL;

        data[tail++] = elem;
        size++;
        return true;
    }

    @Override
    public boolean offer(T elem) {
        return offerLast(elem);
    }

    @Override
    public T poll() {
        return pollFirst();
    }

    @Override
    public T pollFirst() {
        if (isEmpty())
            return null;

        if (head == data.length)
            head = DEFAULT_HEAD;

        size--;
        return data[head++];
    }

    @Override
    public T pollLast() {
        if (isEmpty())
            return null;

        if (tail == 0)
            tail = data.length;

        size--;
        return data[--tail];
    }

    @Override
    public T peekFirst() {
        return data[head];
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public T[] getArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public T peekLast() {
        if (tail == 0)
            return data[data.length - 1];

        return data[tail - 1];
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
}
