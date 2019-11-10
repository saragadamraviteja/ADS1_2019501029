/**
 * ransom using separate chaining implementation.
 * @author raviteja.
 */
import java.util.Arrays;
public class Ransom {
    /**
     * arr which stores elements.
     */
    Node[] arr;
    /**
     * node class
     */
    public class Node {
        String key;
        int value;
        Node next;
        public Node(String k) {
            this.key = k;
            value = 1;
            next = null;
        }
    }
    /**
     * array of strings.
     * @param s String array.
     */
    public Ransom(String[] s) {
        arr = new Node[2 * s.length];
        createDict(s);
    }
    /**
     * hash method for generating hash code.
     */
    public int hash(String k) {
        return ((k.hashCode() & 0x7fffffff) % (arr.length)); 
     }
     /**
      * inserting an key.
      * @param k key
      */
     public void put(String k) {
         if (k == null) {
             return;
         }
         int indx = hash(k); 
        if(arr[indx] == null) {
            arr[indx] = new Node(k);
            return;
        }
        for (Node x = arr[indx]; x != null; x = x.next) {
            if (x.key.equals(k)) {
                x.value = x.value + 1;
                return;
            }
        }
        Node head = new Node(k);
        head.next = arr[indx];
        arr[indx] = head;
     }
    /**
     * getting an key and its value.
     * @param k key.
     * @return value.
     */
     public int get(String k) {
         int indx  = hash(k);
         for (Node x = arr[indx]; x != null; x = x.next) {
             if(x.key.equals(k)) {
                 return x.value;
             }
         }
         return 0;
     }
     /**\
      * sending an keys into an array.
      */
     public void createDict(String[] str) {
         for(int i = 0; i < str.length; i++) {
             put(str[i]);
         }    
     }
     /**
      * checking an ransom or not.
      */
     public boolean check(Ransom that) {
         for (int i = 0; i < this.arr.length; i++) {
            Node x = this.arr[i];
            while (x != null) {
                if (this.get(x.key) > that.get(x.key)) {
                    return false;
                }
                else {
                    x = x.next;
                }
            }
         }
         return true;
     }
     /**
      * for displaying the output.
      */
     public void showString() {
         for (int i = 0; i < arr.length; i++) {
             Node x = arr[i];
             while(x != null) {
                 System.out.println(x.key + ", " + x.value);
                 x = x.next;
             }
         }
         System.out.println("==========");
     }
     /**
      * main method.
      * @param args arguements.
      */
     public static void main (String[] args) {
         String str = "I am ravi I am this I know dash";
         String[] xyz = str.split(" ");
         System.out.println(Arrays.toString(xyz));
         Ransom ransom = new Ransom(xyz);
         ransom.showString();
         String st1 = "ravi is a kidnapper who wrote a ransom note I I I dash know this am am";
         String[] magazine = st1.split(" ");
         Ransom maga = new Ransom(magazine);
         maga.showString();
         System.out.println(ransom.check(maga));
     }




}