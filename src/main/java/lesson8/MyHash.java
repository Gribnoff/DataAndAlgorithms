package lesson8;

import general.MyCollection;

public interface MyHash<K, V> extends MyCollection {
    boolean put(K key, V value);

    V get(K key);

    boolean contains(K key);

    V remove(K key);

    void display();

    interface Entry<K, V> {
        K getKey();
        V getValue();

        void setKey(K key);
        void setValue(V value);
    }
}
