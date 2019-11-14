import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import java.util.Random;
/**
 * RandomizedQueue
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    Item[] arr;
    private int size; 

    // construct an empty randomized queue
    public RandomizedQueue() {
        arr = new Item[4];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        arr[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Random rand = new Random();
        int r = rand.nextInt(size);
        arr[r] = null;
        for (int i = r; i < size;i++) {
            arr[i] = arr[i+1];
        }
        arr[size] = null;
        size--;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args)

}