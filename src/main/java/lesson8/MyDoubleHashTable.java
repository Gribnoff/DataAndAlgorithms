package lesson8;

public class MyDoubleHashTable<K, V> extends MyHashTable<K, V> {
    private static final int DOUBLE_HASH_CONST = 5;

    public MyDoubleHashTable(int maxSize) {
        super(maxSize);
    }

    private int doubleHash(K key) {
        return DOUBLE_HASH_CONST - (key.hashCode() % DOUBLE_HASH_CONST);
    }

    @Override
    protected int getStep(K key) {
        return doubleHash(key);
    }
}
