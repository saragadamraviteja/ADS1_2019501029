import java.util.*;
public class Stack2 {

    private Character [] array;
    private int size;

    Stack2(int capacity) {
        array = new Character[capacity];
        size = 0;
    }
    public void push(Character item) {
        if (size == array.length) {
            resize();
        }
        array[size++] = item;
    }

    public void resize() {
        array = Arrays.copyOf(array, 2 * array.length);
    }

    public Character pop() {
        if (!isEmpty()) {
            Character poppeditem = array[size-1];
            array[--size] = null;
            return poppeditem;
        } 
        return '0';
    } 

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public Character peek() {
        if (size != 0) {
            return  array[size - 1];
        }
        return null;
    }

    public Character[] getarray() {
        return array;
    }
}