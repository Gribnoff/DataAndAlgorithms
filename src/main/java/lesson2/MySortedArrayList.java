package lesson2;

public class MySortedArrayList<E extends Object & Comparable<? super E>> extends MyArrayList<E> {

    @Override
    public void add(E value) {
        checkGrow();
        int index;

        for (index = 0; index < size; index++) {
            if (data[index].compareTo(value) > 0)
                break;
        }

        if (size - index >= 0)
            System.arraycopy(data, index, data, index + 1, size - index);

        data[index] = value;
        size++;
    }

    @Override
    public int indexOf(E value) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (data[mid].equals(value)) {
                return mid;
            }
            else if (data[mid].compareTo(value) > 0) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
