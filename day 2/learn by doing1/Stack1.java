import java.util.*;
public class Stack1 {

    private String [] array;
    private int size;

    Stack1(int capacity) {
        array = new String[capacity];
        size = 0;
    }
    public void push(String item) {
        if (size == array.length) {
            resize();
        }
        array[size++] = item;
    }

    public void resize() {
        array = Arrays.copyOf(array, 2 * array.length);
    }

    public String pop() {
        if (!isEmpty()) {
            String poppeditem = array[size];
            array[--size] = null;
            return poppeditem;
        } 
        return "No elements are present";
    } 

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public String peek() {
        if (size != 0) {
            return  array[size - 1];
        }
        return null;
    }

    public String[] getarray() {
        return array;
    }
}