package HashTable;

public class LinearProbingLD<Key, Value> {

    private int size;
    private int nullKeys = 0;
    private int M = 16;
    private Key[] keys;
    private Value[] values;

    public LinearProbingLD() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    public LinearProbingLD(int capacity) {
        M = capacity;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity) {
        size = size - nullKeys;
        nullKeys = 0;
        LinearProbingLD<Key, Value> temp = new LinearProbingLD<Key, Value>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null && values[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        M = temp.M;
    }

    public void put(Key key, Value val) {

        if (size - nullKeys >= M / 2)
            resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                if (values[i] == null)
                    nullKeys--;
                values[i] = val;
                return;
            }
        }
        keys[i] = key;
        values[i] = val;
        size++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return values[i];
        return null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }

        values[i] = null;

        nullKeys++;
        if (size - nullKeys > 0 && size - nullKeys <= M / 8)
            resize(M / 2);
    }

}
