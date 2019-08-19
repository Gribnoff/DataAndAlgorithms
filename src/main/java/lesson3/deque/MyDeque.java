package lesson3.deque;

import lesson3.queue.MyQueue;

public interface MyDeque<T> extends MyQueue<T> {
    boolean offerFirst(T elem);
    boolean offerLast(T elem);

    T pollFirst();
    T pollLast();

    T peekFirst();
    T peekLast();
}
