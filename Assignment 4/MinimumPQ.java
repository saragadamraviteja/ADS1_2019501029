import java.util.*;
import java.util.Comparator;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * MinimumPQ
 */
public class MinimumPQ<Key> {
    private Key[] arr;
    private int n;
    private Comparator<Key> comparator;

    public MinimumPQ(int capacity) {
        arr = (Key[]) new Object[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key x) {
        if (n == arr.length - 1) {
            resize(2 * arr.length);
        }
        arr[++n] = x;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && greater (k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while(2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater (j , j + 1)) {
                j++;
            } 
            if (! greater(k, j)) {
                break;
            }
            exch(k,j);
            k = j;
        }
    }

    private void exch(int i ,int j) {
        Key swa = arr[i];
        arr[i] = arr[j];
        arr[j] = swa;
    }



    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = arr[1];
        exch(1, n--);
        sink(1);
        arr[n + 1] = null;     // to avoid loiterig and help with garbage collection
        if ((n > 0) && (n == (arr.length - 1) / 4)) resize(arr.length / 2);
        //assert isMinHeap();
        return min;
    }

    private void resize(int capacity) {
        arr = Arrays.copyOf(arr, 2 * arr.length);
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return arr[1];
    }

    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) arr[i]).compareTo(arr[j]) > 0;
        }
        else {
            return comparator.compare(arr[i], arr[j]) > 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("how many elements to insert");
        int yy = sc.nextInt();
        MinimumPQ<Integer> dd = new MinimumPQ(yy);
        for (int i = 0; i < yy; i++) {
            dd.insert(sc.nextInt());
       }
        System.out.println("how many elements to delete");
        int zz = sc.nextInt();
        for (int j = 0; j < zz; j++) {
            dd.delMin();
        }
        sc.close();
        System.out.println(Arrays.toString(dd.arr));   
    }
}