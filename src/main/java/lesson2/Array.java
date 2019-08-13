package lesson2;

public interface Array<T> {

    int DEFAULT_CAPACITY = 16;

    int size();

    T get(int index);

    void add(T elem);

    void remove(T elem);
    void removeByIndex(int index);

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

    @SuppressWarnings("unchecked")
    default void addAll(T... elems) {
        for (T elem : elems) {
            add(elem);
        }
    }
}
