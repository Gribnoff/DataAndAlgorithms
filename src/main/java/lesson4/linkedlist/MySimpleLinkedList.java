package lesson4.linkedlist;

public class MySimpleLinkedList<T> implements MyLinkedList<T> {
    protected Node<T> first;
    protected int size;

    @Override
    public void addFirst(T elem) {
        Node<T> node = new Node<>(elem);
        node.next = first;
        first = node;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            return null;

        T elem = first.elem;
        first = first.next;

        size--;
        return elem;
    }

    @Override
    public boolean remove(T elem) {
        Node<T> prev = null;
        Node<T> current = first;
        while (current != null) {
            if (current.elem.equals(elem))
                break;

            prev = current;
            current = current.next;
        }

        if (current == null)
            return false;
        else if (current == first)
            first = current.next;
        else
            prev.next = current.next;

        size--;
        return true;
    }

    @Override
    public boolean contains(T elem) {
        Node<T> current = first;
        while (current != null) {
            if (current.elem.equals(elem))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public T getFirst() {
        return first != null ? first.elem : null;
    }

    @Override
    public void print() {
        Node<T> current = first;
        while (current != null) {
            System.out.println(current.elem);
            current = current.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
