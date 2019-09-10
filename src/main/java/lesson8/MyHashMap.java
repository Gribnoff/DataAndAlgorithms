package lesson8;

import lesson4.linkedlist.MyLinkedListFull;

public class MyHashMap<K, V> implements MyHash<K, V> {

    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;

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

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private MyLinkedListFull<Node<K, V>>[] data;
    protected int size;
    protected final int maxSize;

    @SuppressWarnings("unchecked")
    public MyHashMap(int maxSize) {
        this.maxSize = maxSize;
        this.data = new MyLinkedListFull[maxSize];
    }

    private int hash(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);

        if (data[index] == null)
            data[index] = new MyLinkedListFull<>();

        for (Node<K, V> node : data[index]) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return true;
            }
        }

        data[index].addLast(new Node<>(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if (index == -1)
            return null;

        MyLinkedListFull<Node<K, V>> list = data[index];

        if (list != null)
            for (Node<K, V> node : list) {
                if (node.getKey().equals(key)) {
                    return node.getValue();
                }
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
        if (index == -1)
            return null;

        MyLinkedListFull<Node<K, V>> list = data[index];
        V result = null;

        if (list != null)
            for (Node<K, V> node : list) {
                if (node.getKey().equals(key)) {
                    result = node.getValue();
                    list.remove(node);
                    size--;
                    break;
                }
            }

        return result;
    }

    @Override
    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d =", i);

            if (data[i] != null)
                for (Node<K, V> node : data[i]) {
                    System.out.printf(" [%s]", node);
                }
            else
                System.out.print(" [null]");
            System.out.println();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
