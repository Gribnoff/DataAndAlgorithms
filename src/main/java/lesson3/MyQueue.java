package lesson3;

import general.MyCollection;

public interface MyQueue<T> extends MyCollection {

    boolean offer(T elem);

    @SuppressWarnings("unchecked")
    default boolean offerAll(T... elems) {
        for (T elem : elems) {
            if (isFull())
                return false;
            offer(elem);
        }

        return true;
    }

    T poll();

    T peek();
}
