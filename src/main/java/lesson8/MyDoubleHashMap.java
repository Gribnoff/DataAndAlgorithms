package lesson8;

public class MyDoubleHashMap<K, V> extends MyHashMap<K, V> {
    private final int DOUBLE_HASH_CONST = maxSize - 1;

    public MyDoubleHashMap(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int hash(K key) {
        return DOUBLE_HASH_CONST - (key.hashCode() % DOUBLE_HASH_CONST);
    }
}
