import edu.princeton.cs.algs4.*;
import java.util.NoSuchElementException;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        // int cnt = 0;
        RandomizedQueue tt = new RandomizedQueue();
        try {
            while(!StdIn.isEmpty()) {
                if((StdIn.readString()) != null && ((StdIn.readString()).length()) > 0) {
                tt.enqueue(StdIn.readString());
                // cnt++;
                }
            }
            for (int h = 0; h < k; h++) {
                StdOut.println(tt.dequeue());
            }

        } catch (NoSuchElementException e){ 
        }
    }
 }