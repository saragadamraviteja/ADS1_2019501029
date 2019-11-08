import java.util.Iterator;
/**
 * Queue class.
 * @param <Item> generic.
 */
public class Queue<Item> implements Iterable<Item> {
    /**
     * first stores element.
     */
    private Node<Item> first;
    /**
     * last stores element.
     */
    private Node<Item> last;
    /**
     * it stores the size.
     */
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    /**
     * Queue constructor for fields.
     */
    public Queue() {
        first = null;
        last = null;
        size = 0;
    }
    /**
     * size of the list
     */
    public int size() {
        return size;
    }
    /**
     * adding elements to the list.
     */
    public void Enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        size++;
    }
    /**
     * removing elements from the list.
     */
    public Item Dequeue() {
        if (isEmpty()) return null;
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = null;
        return item;
    }
    /**
     * checking list is empty or not.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * to string method.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    /**
     * iterator 
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    /**
     * Iterator.
     */
    private class ListIterator implements Iterator<Item> {
        Node<Item> current = first;
        /**
         * has next method
         */
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if(hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            }
            return null;
        }
        public void remove() {
            try{
                throw new Exception();
            }
            catch(Exception Ex) {
                System.out.println("Not supported Function");
            }
        }
    }
}
