import java.util.NoSuchElementException;
public class CircularLinkedList<Item> {
    private Node last;
    private int size;

    public class Node {
        private Item item;
        private Node next;
    }

    public CircularLinkedList() {
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void enqueue(Item item) {
        if (size == 0) {
            last = new Node();
            last.item = item;
            last.next = last;
        } else {
        Node temp = new Node(); 
        temp.item = item;
        temp.next = last.next;
        last.next = temp;
        last = temp;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        } 
        Node temp  = last.next;
        last.next = last.next.next;
        size--;
        return temp.item;
    }
    public static void main(String[] args) {
        CircularLinkedList<String> obj = new CircularLinkedList();
        obj.enqueue("ravi");
        obj.enqueue("teja");
        obj.enqueue("good");
        obj.enqueue("boy");
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
    }
}