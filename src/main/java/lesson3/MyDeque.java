package lesson3;

public interface MyDeque<T> extends MyQueue<T> {
    boolean offerFirst(T elem);
    boolean offerLast(T elem);

    T pollFirst();
    T pollLast();

    T peekFirst();
    T peekLast();
}
