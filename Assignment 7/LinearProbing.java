/**
 * Linear probing implementation.
 * @author raviteja.
 */
import java.util.Arrays;
import java.util.*;
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
    public LinearProbing() {
        keys = (Key[]) new Object[1000000];
        values = (Value[]) new Object[1000000];
        // createDict(ks, vs);
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
 * main method.
 * @param args arguements.
 */
float count = 0;
 public static void main(String[] args) {
     
     //DecimalFormat df = new DecimalFormat();
     //df.setMaximumFractionDigits(2);
     Random rr = new Random();
     LinearProbing<Integer, Integer> ob = new LinearProbing();
     int k = 0;
     while (k < 500000) {
     int  ss = rr.nextInt(10000);
     int dd = rr.nextInt(2);
     ob.put (ss, dd);
     k++;
     }
     //System.out.println(Arrays.toString(ob.keys));
     int l = 0;
     while (l < 500000) {
         System.out.println(ob.get(l));
         if (ob.get(l) != null) {
            ob.count++;
            // System.out.println(ob.count);
         } 
         l = l + 100;
     }
     System.out.println(ob.count);
     double d = (double) (ob.count)/1000000;
     System.out.format("%.5f",d);
 }
}
