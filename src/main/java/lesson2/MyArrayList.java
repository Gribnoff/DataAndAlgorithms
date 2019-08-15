package lesson2;

import java.util.Arrays;

public class MyArrayList<T extends Object & Comparable<? super T>> implements MyList<T> {
    protected T[] data;
    protected int size;

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    public MyArrayList(int capacity) {
        this.data = (T[]) new Object[capacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(T[] data) {
        this.data = data;
        size = data.length;
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

    @Override
    public T get(int index) {
        return data[index];
    }

    @Override
    public void add(T elem) {
        checkGrow();
        data[size++] = elem;
    }

    public void add(int index, T elem) {
        checkGrow();
        if (size - index >= 0)
            System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = elem;
    }

    protected void checkGrow() {
        if (size == data.length)
            data = Arrays.copyOf(data, size * 2);
    }

    @Override
    public boolean remove(T elem) {
        int index = indexOf(elem);
        if (index != -1) {
            removeByIndex(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeByIndex(int index) {
        checkIndex(index);

        if (size - 1 - index >= 0)
            System.arraycopy(data, index + 1, data, index, size - 1 - index);

        data[--size] = null;

        return true;
    }

    private void checkIndex(int index) {
        if (index >= 0 && index < size)
            return;
        throw new ArrayIndexOutOfBoundsException(String.format("Invalid index value: %d; array size is %d", index, size));
    }

    @Override
    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }

    @Override
    public int indexOf(T elem) {
        for (int i = 0; i < size; i++) {
            if (elem.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if(data[j].compareTo(data[j + 1]) > 0)
                    swap(j, j + 1);
            }
        }
    }

    private void swap(int index1, int index2) {
        T buf = data[index1];
        data[index1] = data[index2];
        data[index2] = buf;
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[minIndex].compareTo(data[j]) > 0)
                    minIndex = j;
            }
            swap(i, minIndex);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            T buf = data[i];
            int index = i;

            while (index > 0 && buf.compareTo(data[index - 1]) < 0) {
                data[index] = data [index - 1];
                index--;
            }
            data[index] = buf;
        }
    }

    @Override
    public void println() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> arrayList = (MyArrayList<?>) o;
        return size == arrayList.size &&
                Arrays.equals(data, arrayList.data);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
