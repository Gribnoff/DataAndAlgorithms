package lesson2;

import java.util.Arrays;

public class ArrayList<T extends Object & Comparable<? super T>> implements Array<T>{
    private T[] data;
    private int size;

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    public ArrayList(int capacity) {
        this.data = (T[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(T[] data) {
        this.data = data;
        size = data.length;
    }

    @Override
    public int size() {
        return size;
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

    private void checkGrow() {
        if (size == data.length)
            System.arraycopy(data, 0, data, 0, size * 2);
    }

    @Override
    public void remove(T elem) {
        int index = indexOf(elem);
        if (index != -1)
            removeByIndex(index);
    }

    @Override
    public void removeByIndex(int index) {
        checkIndex(index);

        if (size - 1 - index >= 0)
            System.arraycopy(data, index + 1, data, index, size - 1 - index);

        data[--size] = null;
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
        Arrays.stream(data).forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList<?> arrayList = (ArrayList<?>) o;
        return size == arrayList.size &&
                Arrays.equals(data, arrayList.data);
    }
}
