import java.util.Arrays;
/**
 * BTS implementation using arrays.
 * @author raviteja.
 * @param <Key> .key type
 * @param <Value>  value type.
 */
public class BSTArrays<Key extends Comparable<Key>,Value> {
    Key[] keys;
    Value[] values;
    int[] left;
    int[] right;
    int[] sizes;
    int size;
    /**
     * Initializes the instance variables
     * @param cap the capacity of the keys and values array.
     */
    public BSTArrays(int cap) {
        keys = (Key[]) new Comparable[cap];
        values = (Value[]) new Object[cap];
        left = new int[cap];
        right = new int[cap];
        sizes = new int[cap];
        size = 0;
    }

    /**
     * This method inserts the key value pairs into the BST
     * @param k the key in key value pair.
     * @param v the value associated with the key.
     */
    public void put(Key k, Value v) {
        if (k == null) {
            return;
        }
        put(1, k, v);
    }
    private void put(int index, Key key, Value val) {
        if (index > keys.length - 1) {
            System.out.println("Array is full");
            return;
        }
        if (keys[index] == null) {
            keys[index] = key;
            values[index] = val;
            return;
        }
        if (key.compareTo(keys[index]) < 0) {
            left[index] = 2 * index;
            put(2 * index, key, val);
        } else if (key.compareTo(keys[index]) > 0) {
            right[index] = (2 * index) + 1;
            put((2 * index) + 1, key, val);
        } else {
            values[index] = val;
        }

        sizes[index] = 1 + sizes[2 * index] + sizes[(2 * index) + 1];
        return;
    }

    /**
     * This method shows the BST in root, left and right format.
     */
    public void display() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                System.out.println("(" + i + "-" + keys[i] + "," + values[i] + ")" + "-" + left[i] + "-" + right[i]);
            }
        }
    }

    public value get(final Value value) {
        int index = 0;
        int compValue = value.compareTo(data[index]);
        while (compValue != 0) {
            if (compValue < 0) {
                index = (2* index) +1;
                if (data[index] == null) {
                    break;
                }
            } else {
                index = (2 * index) + 2;
                if (data[index] == null) {
                    break;
                }
            }
            compValue = value.compareTo(data[index]);
        }
        return data[index];
    }
/**
 * main method
 * @param args arguements.
 */
    public static void main(String[] args) {
        BSTArrays<String, Integer> bsta = new BSTArrays<String, Integer>(100);
        bsta.put("A", 1);
        bsta.put("B", 3);
        bsta.put("A", 7);
        bsta.put("R", 2);
        bsta.put("X", 4);
        bsta.put("H", 1);
        bsta.put("E", 7);
        bsta.put("X", 9);
        bsta.display();
    }
}
