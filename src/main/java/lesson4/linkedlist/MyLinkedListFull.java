package lesson4.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedListFull<T> implements MyFullLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public void addFirst(T elem) {
        first = new Node<>(elem, null, first);

        if (size == 0)
            last = first;
        else
            first.next.prev = first;
        size++;
    }

    @Override
    public void addLast(T elem) {
        last = new Node<>(elem, last, null);

        if (size == 0)
            first = last;
        else
            last.prev.next = last;

        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            return null;

        T elem = first.elem;
        first = first.next;
        first.prev = null;

        size--;
        return elem;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            return null;

        T elem = last.elem;
        last = last.prev;
        last.next = null;

        size--;
        return elem;
    }

    @Override
    public boolean remove(T elem) {
        Node<T> current = first;
        while (current != null) {
            if (current.elem.equals(elem))
                break;

            current = current.next;
        }

        if (current == null)
            return false;
        else if (current == first) {
            first = current.next;
            first.prev = null;
        } else if (current == last) {
            last = current.prev;
            last.next = null;
        } else {
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }

        size--;
        return true;
    }

    @Override
    public boolean contains(T elem) {
        for (T t : this) {
            if (elem.equals(t))
                return true;
        }
        return false;
    }

    @Override
    public T getFirst() {
        return first.elem;
    }

    @Override
    public T getLast() {
        return last.elem;
    }

    @Override
    public Node<T> getFirstNode() {
        return first;
    }

    @Override
    public Node<T> getLastNode() {
        return last;
    }

    @Override
    public void print() {
        this.forEach(System.out::println);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    public Iterator<T> descendingIterator() {
        return new DescItr();
    }

    class Itr implements Iterator<T> {
        private Node<T> current;
        private Node<T> next;
        private int nextIndex;

        Itr() {
            next = (size > 0) ? first : null;
            nextIndex = 0;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            current = next;
            next = next.next;
            nextIndex++;
            return current.elem;
        }
    }

    class DescItr implements Iterator<T> {
        private Node<T> current;
        private Node<T> next;
        private int nextIndex;

        DescItr() {
            next = (size > 0) ? last : null;
            nextIndex = size;
        }

        @Override
        public boolean hasNext() {
            return nextIndex > 0;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            current = next;
            next = next.prev;
            nextIndex--;
            return current.elem;
        }
    }
}
