import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;
    }

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        if (size == 0) {
            first = new Node();
            first.item = item;
            last = first;
        } else {
            Node temp = first;
            first = new Node();
            first.item = item;
            first.next = temp;
            temp.previous = first;
        }
        size++;
        // System.out.println(first.item);
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        Node temp1 = new Node();
        temp1.item = item;
        if (last != null) {
            temp1.previous = last;
            last.next = temp1;
        } 
        last = temp1;
        if (first == null) {
            first = last;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        } 
        Item item = first.item;
        if (size == 1) {
            last = null;
            first = null;
        } else {
            first.next.previous = null;
            first = first.next;
        }
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Item item = last.item;
        if (size == 1) {
            last = null;
            first = null;
        } else {
            last.previous.next = null;
            last = last.previous;
        }
        size--;
        return item;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node<Item> current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Deque<String> obj = new Deque();
        obj.addFirst("ravi");
        obj.addLast("teja");
        // obj.addLast("good");
        // obj.removeLast();
        obj.removeFirst();
        obj.size();
        obj.isEmpty();
        for (String string : obj) {
            StdOut.println(string);
        }
    }
}
