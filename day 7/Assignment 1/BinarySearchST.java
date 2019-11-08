import java.util.*;
/**
 *  Implement the API using BinarySearchST.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * key is an array of Key type which stores elements.
     */
    Key[] keys;
    Value[] value;
    int x;
    public BinarySearchST() {
        keys = (Key[]) new Comparable[15];
        value = (Value[]) new Comparable[15];
        x = 0;
    }
    public boolean isEmpty() {
        return x == 0;
    }

    public void put(Key k, Value v) {
        if (v == null) {
            int yy = rank(k);
            for (int j = yy; j < x - 1; j++) {
                keys[j] = keys[j + 1];
                value[j] = value[j + 1];
            }
            keys[x - 1] = null;
            value[x - 1] = null;
            x--;
            return;
        }
        if (isEmpty()) {
            keys[x] = k;
            value[x] = v;
            x = x + 1;
            return;
        }
        int yy = rank(k);
        if (yy < x && keys[yy].equals(k)) {
            value[yy] = v;
            return;
        }
        for (int i = x; i > yy; i--) {
            keys[i] = keys[i - 1];
            value[i] = value[i - 1];         
        }
        keys[yy] = k;
        value[yy] = v;
        x = x + 1;
        if (x == keys.length) {
            resize();
        }
    }

    public void resize() {
        keys = Arrays.copyOf(keys, 2 * x);
        value = Arrays.copyOf(value, 2 * x);
    }

    public int rank(Key k) {
        int lo = 0;
        int hi = x - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = k.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else if (cmp == 0) {
                return mid;
            }
            }
            return lo;
            }

    public Value get(Key k) {
        int index = rank(k);
        if (contains(k)) {
            return value[index];
        }
            return null;
    }
        

    public boolean contains(Key k) {
        int index = rank(k);
        if (keys[index] == null) {
            return false;
        }
        if (keys[index].equals(k)) {
            return true;
        }
        return false;
    }

    public Key max() {
        if (x == 0) {
            return null;
        } else {
            return keys[x - 1];
        }
    }

    public void deleteMin() {
        for (int i = 0; i < x - 1; i++) {
            keys[i] = keys[i + 1];
            value[i] = value[i + 1];
        }
        value[x - 1] = null;
        keys[x - 1] = null;
        x--;
    }

    public String keys() {
        String str = "";
        for (int i = 0; i < x; i++) {
            str += keys[i] + " ";
        }
        return str;
     }

    public Key floor(Key k) {
        int yy = rank(k);
        if (yy < x && keys[yy].equals(k)) {
            return keys[yy];
        } else {
            return keys[yy - 1];
        }
    }
}
    
