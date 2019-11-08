import java.util.*;
/**
 *  Implement the API using BinarySearchST.
 * @author raviteja.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * key is an array of Key type which stores keys of elements.
     */
    Key[] keys;
    /**
     * value is an array which stores values of elements.
     */
    Value[] value;
    /**
     * x represents the sizeof the array.
     */
    int x;
    /**
     * BinearySearchST is a constructor which is having fields 
     * of keys and values.
     */
    public BinarySearchST() {
        keys = (Key[]) new Comparable[15];
        value = (Value[]) new Comparable[15];
        x = 0;
    }
    /**
     * whether the array is empty or not.
     * @return boolean either true or false.
     */
    public boolean isEmpty() {
        return x == 0;
    }
    /**
     * this method helps to insert the keys and values.
     */
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
    /**
     * resize the array when its getting filled.
     */
    public void resize() {
        keys = Arrays.copyOf(keys, 2 * x);
        value = Arrays.copyOf(value, 2 * x);
    }
    /**
     * it shows the rank of the key 
     * @param k is the key.
     * @return returns index of the key.
     */
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
    /**
     * it will get the required value of the key.
     * @param k is the key.
     * @return returns value.
     */
    public Value get(Key k) {
        int index = rank(k);
        if (contains(k)) {
            return value[index];
        }
            return null;
    }
        
    /**
     * it checks whether it contains or not in array.
     * @param k is the key.
     * @return  true or false.
     */
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
    /**
     * it finds out the maximum.
     * @return maximum key.
     */
    public Key max() {
        if (x == 0) {
            return null;
        } else {
            return keys[x - 1];
        }
    }
    /**
     * used to delete the minimum key along with value.
     */
    public void deleteMin() {
        for (int i = 0; i < x - 1; i++) {
            keys[i] = keys[i + 1];
            value[i] = value[i + 1];
        }
        value[x - 1] = null;
        keys[x - 1] = null;
        x--;
    }
    /**
     * it displays the floor of the key.
     * @param k key
     * @return returns key
     */
    public Key floor(Key k) {
        int yy = rank(k);
        if (yy < x && keys[yy].equals(k)) {
            return keys[yy];
        } else {
            return keys[yy - 1];
        }
    }
    /**
     * Iterable method.
     * @return returns the output.
     */
    public Iterable<Key> keys() {
        Queue<Key> dd = new Queue();
        for (int i = 0; i < x; i++) {
            dd.Enqueue(keys[i]);
        }
        return dd;
    }
}
    
