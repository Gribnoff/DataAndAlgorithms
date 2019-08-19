package lesson4.linkedlist;

public class MyTwoSideLinkedList<T> extends MySimpleLinkedList<T> {

    private Node<T> last;

    public void addLast(T elem) {
        Node<T> node = new Node<>(elem);

        if (isEmpty())
            first = node;
        else
            last.next = node;
        last = node;
        size++;
    }

    @Override
    public void addFirst(T elem) {
        super.addFirst(elem);
        if (size == 1)
            last = first;
    }

    @Override
    public T removeFirst() {
        T elem = super.removeFirst();
        if (isEmpty())
            last = null;

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
        else if (current == first && current == last)
            first = last = null;
        else if (current == first)
            first = current.next;
        else if (current == last) {
            last = prev;
            last.next = null;
        }
        else
            prev.next = current.next;

        size--;
        return true;
    }
}
