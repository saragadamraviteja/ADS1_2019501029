/**
 * Linear probing implementation.
 * @author raviteja.
 */
import java.util.Arrays;
public class LinearProbing<Key, Value> {
    /**
     * which stores the keys in an array
     */
    Key[] keys;
    /**
     * which stores an values in array.
     */
    Value[] values;
    /**
     * linear probing constructor for fields.
     */
    public LinearProbing(Key[] ks, Value[] vs) {
        keys = (Key[]) new Object[ks.length * 100];
        values = (Value[]) new Object[ks.length * 100];
        createDict(ks, vs);
    }
    /**
     * for generating hash code.
     */
    public int hash(Key k) {
        return ((k.hashCode()& 0x7fffffff) % (keys.length));
    }
    /**
     * it inserts an key into an array.
     */
    public void put(Key k, Value v) {
        if (k == null) {
            return;
        }
        int index = hash(k);
        int i;
        for (i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(k)) {
                values[i] = v;
                return; 
            }
        }
        keys[i] = k;
        values[i] = v;
    }
    /**
     * it searches an element in an array.
     * @param k key
     * @return value.
     */
    public Value get(Key k) {
        if (k == null) {
            return null;
        }
        int index = hash(k);
        for (int i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(k)) {
                return values[i];
            }
        }
        return null;
    }
    /**
     * delete an key
     * @param k key.
     */
    public void delete(Key k) {
        if (k == null){
            return;
        }
        int index = hash(k);
        for (int i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(k)) {
                keys[i] = null;
                values[i] = null;
                for (int j = i + 1; keys[j] != null; j = (j + 1) % keys.length) {
                    if (hash(keys[j]) != index) {
                        continue;
                    }
                    put(keys[j], values[j]);
                    keys[j] = null;
                    values[j] = null;                }
            }
            return;
        }
    }
/**
 * for rehasing and arranging elements.
 * @param k key
 * @param v value.
 */
public void createDict(Key[] k, Value[] v) {
    for (int i = 0; i < k.length; i++) {
        put(k[i], v[i]);
    }
}
/**
 * displays an elemnets in ana array.
 */
public void display() {
    for (int i = 0; i < keys.length; i++) {
        if (keys[i] != null) {
            System.out.println(keys[i] + ", " + values[i]);
        }
    }
    System.out.println("============");
}
/**
 * main method.
 * @param args arguements.
 */
public static void main(String[] args) {
    String str = "I am ravi I am this I know dash";
    String[] test1_keys = str.split(" ");
    System.out.println(Arrays.toString(test1_keys));
    Integer[] test1_vals = {1,2,3,4,5,6,7,8,9};
    System.out.println(Arrays.toString(test1_vals));
    LinearProbing<String, Integer> lp1 = new LinearProbing(test1_keys, test1_vals);
    lp1.display();
}
}
