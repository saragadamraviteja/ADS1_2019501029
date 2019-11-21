import java.util.*;
public class LinearProbing<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values

    public LinearProbing() {
        this(INIT_CAPACITY);
    }

    public LinearProbing(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[1000000];
        vals = (Value[]) new Object[1000000];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % 1000000;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        // if (val == null) {
        //     delete(key);
        //     return;
        // }

        // double table size if 50% full
        // if (n >= m/2) resize(2*m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % 1000000) {
            // System.out.println(keys[i]);
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }
double count;
    public static void main(String[] args) {
        Random rr = new Random();
        LinearProbing<Integer, Integer> ob = new LinearProbing();
        int k = 0;
        while (k < 500000) {
            int ss = rr.nextInt(500000);
            int dd = rr.nextInt(500000);
            ob.put(ss, dd);
            k++;
            // System.out.println(k);
        }
        // System.out.println("here");
        int l = 0;
        while (l < 500000) {
            if (ob.get(l) != null) {
                ob.count++;
                // System.out.println(Arrays.toString(ob.keys));
                // System.out.println(ob.count);
            }
            l = l + 100;
        }
        System.out.println(ob.count);
        // double d = ;
        System.out.printf("%.2f", (ob.count/10000));
    }
}

