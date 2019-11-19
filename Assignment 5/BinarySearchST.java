// package edu.princeton.cs.algs4;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 5;
    public Key[] keys;
    public Value[] vals;
    private int n = 0;

    /**
     * Initializes an empty symbol table.
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     * @param capacity the maximum capacity
     */
    public BinarySearchST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }   

    // resize the underlying arrays
    private void resize(int capacity) {
        keys = Arrays.copyOf(keys, 2 * n);
        vals = Arrays.copyOf(vals, 2 * n);
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val)  {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 

        if (val == null) {
            delete(key);
            return;
        }

        if(isEmpty()) {
            keys[n] = key;
            vals[n] = val;
            n++;
            return;
        }
        if (key.compareTo(keys[n - 1]) > 0) {
            keys[n] = key;
            vals[n] = val;
            n++;
        } else if (key.compareTo(keys[n - 1]) == 0) {
            //keys[n - 1] = key;
            vals[n - 1] = val;
        } else if (key.compareTo(keys[n - 1]) < 0){
            int i = rank(key);
            for (int j = n; j > i; j--)  {
                keys[j] = keys[j-1];
                vals[j] = vals[j-1];
            }
            keys[i] = key;
            vals[i] = val;
            n++;
        }
        // int i = rank(key);

        // // key is already in table
        // if (i < n && keys[i].compareTo(key) == 0) {
        //     vals[i] = val;
        //     return;
        // }

        // // insert new key-value pair
        // if (n == keys.length) resize(2*keys.length);

        // for (int j = n; j > i; j--)  {
        //     keys[j] = keys[j-1];
        //     vals[j] = vals[j-1];
        // }
        // keys[i] = key;
        // vals[i] = val;
        // n++;

        // assert check();
    } 

    /**
     * Removes the specified key and associated value from this symbol table
     * (if the key is in the symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (isEmpty()) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;

        // resize if 1/4 full
        if (n > 0 && n == keys.length/4) resize(keys.length/2);

        //assert check();
    } 

    private int rank(Key key)
{
	int lo = 0, hi = n - 1;
	while (lo <= hi) {
	int mid = lo + (hi - lo) / 2;
	int cmp = key.compareTo(keys[mid]);
	if (cmp < 0)  {
        hi = mid -1;
    }
	if (cmp > 0 ) lo = mid +1;
	else if (cmp ==0) return mid;
	}
	return lo;
}
}

