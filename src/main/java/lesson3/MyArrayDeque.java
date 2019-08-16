package lesson3;

import java.util.Arrays;

public class MyArrayDeque<T> extends MyArrayQueue<T> implements MyDeque<T> {

    public MyArrayDeque() {
        super();
    }

    public MyArrayDeque(int capacity) {
        super(capacity);
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
        return offer(elem);
    }

    @Override
    public T pollFirst() {
        return poll();
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
        return peek();
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

    @Override
    public T[] getArray() {
        return Arrays.copyOf(data, size);
    }
}
