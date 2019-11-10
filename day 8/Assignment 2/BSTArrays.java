import java.util.Arrays;

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
     * Complexity is of ~O(N)
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
        // System.out.println(myKeys[index]);
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
     * Complexity is of ~O(N)
     */
    public void display() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                System.out.println("(" + i + "-" + keys[i] + "," + values[i] + ")" + "-" + left[i] + "-" + right[i]);
            }
        }
    }

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
