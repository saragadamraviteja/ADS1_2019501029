import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import java.util.Random;
import java.util.Arrays;
/**
 * RandomizedQueue
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    Item[] arr;
    private int size; 

    // construct an empty randomized queue
    public RandomizedQueue() {
        arr = (Item[]) new Object[150];
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
        if (item == null) {
            throw new NullPointerException();
        }
        if (size >= 0.5 * (arr.length)) {
            resize();
        } 
        arr[size++] = item;
    }

    public void resize() {
        if (size >= 0.5 *(arr.length)) {
        arr = Arrays.copyOf(arr, 2 * arr.length);
        } else if (size <= 0.25 * (arr.length)) {
            arr = Arrays.copyOf(arr, (1/2) * arr.length);
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Random rand = new Random();
        int r = rand.nextInt(size);
        Item tempo = arr[r]; 
        arr[r] = null;
        for (int i = r; i < size;i++) {
            arr[i] = arr[i+1];
        }
        arr[size] = null;
        size--;
        return tempo;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Random rnd = new Random();
        int t = rnd.nextInt(size);
        return arr[t];
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private int i;
        public boolean hasNext() {
            return i < size;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = arr[i];
            i++;
            return item;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> objj = new RandomizedQueue();
        objj.enqueue("ravi");
        objj.enqueue("teja");
        objj.enqueue("good boy");
        objj.dequeue();
        objj.size();
        objj.isEmpty();
        for (String string : objj) {
            StdOut.println(string);
        }
    }

}