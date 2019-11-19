import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;
/**
 * permutation implemantation.
 */
public class Permutation {
    /**
     * main method.
     */
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue tt = new RandomizedQueue();
        try {
            while(!StdIn.isEmpty()) {
                if((StdIn.readString()) != null && ((StdIn.readString()).length()) > 0) {
                tt.enqueue(StdIn.readString());
                }
            }
            for (int h = 0; h < k; h++) {
                StdOut.println(tt.dequeue());
            }

        } catch (NoSuchElementException e){ 
        }
    }
 }