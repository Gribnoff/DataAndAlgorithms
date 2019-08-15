package lesson3;

public class MyPriorityQueue<T extends Object & Comparable<? super T>> extends MyArrayQueue<T> {

    public MyPriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    public boolean offer(T elem) {
        if (isFull())
            return false;

        if (isEmpty()) {
            data[size++] = elem;
            return true;
        }

        int i;
        for (i = size - 1; i >= 0; i--) {
            if (elem.compareTo(data[i]) > 0)
                data[i + 1] = data[i];
            else
                break;
        }

        data[i + 1] = elem;
        size++;
        return true;

    }

    @Override
    public T poll() {
        return isEmpty() ? null : data[--size];
    }

    @Override
    public T peek() {
        return isEmpty() ? null : data[size - 1];
    }
}
