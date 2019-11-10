import java.util.Arrays;
public class Ransom {
    Node[] arr;

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

    public Ransom(String[] s) {
        arr = new Node[2 * s.length];
        // xy = s;
        createDict(s);
    }

    public int hash(String k) {
        return ((k.hashCode() & 0x7fffffff) % (arr.length)); 
     }

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

     public int get(String k) {
         int indx  = hash(k);
         for (Node x = arr[indx]; x != null; x = x.next) {
             if(x.key.equals(k)) {
                 return x.value;
             }
         }
         return 0;
     }

     public void createDict(String[] str) {
         for(int i = 0; i < str.length; i++) {
             put(str[i]);
         }    
     }

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