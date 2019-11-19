import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
/**
 * RandomizedQueue
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] arr;
    private int size; 

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        arr = (Item[]) new Object[150];
        size = 0;
    }

    /**
     * is the randomized queue empty
     * @return boolean true of false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items on the randomized queue
     * @return size.
     */
    public int size() {
        return size;
    }

    /**
     * add the item
     * @param item item.
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size >= 0.5 * (arr.length)) {
            resize();
        } 
        arr[size++] = item;
    }
    /**
     * resize of the array.
     */
    private void resize() {
        if (size >= 0.5 *(arr.length)) {
        arr = Arrays.copyOf(arr, 2 * arr.length);
        } else if (size <= 0.25 * (arr.length)) {
            arr = Arrays.copyOf(arr, (1/2) * arr.length);
        }
    }

    /**
     * remove and return a random item
     * @return item.
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int r = StdRandom.uniform(size);
        Item tempo = arr[r]; 
        arr[r] = null;
        for (int i = r; i < size;i++) {
            arr[i] = arr[i+1];
        }
        arr[size] = null;
        size--;
        return tempo;
    }

    /**
     * return a random item (but do not remove it).
     * @return random item.
     */
    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int tempi = StdRandom.uniform(size);
        return arr[tempi];
    }
    /**
     * itertor method calling.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    /**
     * ListIteratoe class.
     */
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

    /**
     * main method.
     */
    public static void main(String[] args) {
        RandomizedQueue<String> objj = new RandomizedQueue();
        objj.enqueue("ravi");
        objj.enqueue("teja");
        objj.enqueue("good boy");
        objj.enqueue("also");
        objj.dequeue();
        objj.size();
        objj.isEmpty();
        for (String string : objj) {
            StdOut.println(string);
        }
    }

}