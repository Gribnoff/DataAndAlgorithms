package lesson8;

import lesson4.linkedlist.MyLinkedListFull;

public class MyHashMap2<K, V> implements MyHash<K, V> {

    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        Node<K, V> getNext() {
            return next;
        }

        void setNext(Node<K, V> next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Node<K, V>[] data;
    protected int size;
    protected final int maxSize;

    @SuppressWarnings("unchecked")
    public MyHashMap2(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Node[maxSize];
    }

    protected int hash(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);
        Node<K, V> current = data[index];
        Node<K, V> previous = null;

        if (current == null) {
            data[index] = new Node<>(key, value);
            size++;
            return true;
        } else {
            while (current != null) {
                if (current.getKey().equals(key)) {
                    current.setValue(value);
                    return true;
                }
                previous = current;
                current = current.getNext();
            }
        }

        previous.setNext(new Node<>(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        Node<K, V> current = data[index];

        while (current != null) {
            if (current.getKey().equals(key))
                return current.getValue();
            current = current.getNext();
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);

        Node<K, V> current = data[index];
        Node<K, V> previous = null;

        V result = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (previous == null)
                    data[index] = current.getNext();
                else
                    previous.setNext(current.getNext());

                result = current.getValue();
                current = null;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        size--;
        return result;
    }

    @Override
    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d =", i);

            Node<K, V> current = data[i];

            do {
                System.out.printf(" [%s]", current);
                current = current.getNext();
            } while (current != null);
            System.out.println();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
