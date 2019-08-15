package lesson2;

import general.MyCollection;

public interface MyList<T> extends MyCollection {

    T get(int index);

    void add(T elem);

    @SuppressWarnings("unchecked")
    default void addAll(T... elems) {
        for (T elem : elems) {
            add(elem);
        }
    }

    boolean remove(T elem);
    boolean removeByIndex(int index);

    boolean contains(T elem);
    @SuppressWarnings("unchecked")
    default boolean containsAll(T... elems) {
        for (T elem : elems) {
            if (!contains(elem))
                return false;
        }
        return true;
    }

    int indexOf(T elem);

    void println();

    void sortBubble();

    void sortSelect();

    void sortInsert();
}
