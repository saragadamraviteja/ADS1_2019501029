import java.util.*;
/**
 * In This class we are using stack and performing operations
 * and methods like pop, push.
 */
public final class Javastack {
    private Javastack() {
        // for check style
    }
    /**
     * this method uses the pop and push methods from the stack class
     * and displays the string output.
     * @param s input string.
     */
    public static void java(final String s) {
        String[] arr = s.split(" ");
        Stack1 obj = new Stack1(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("-")) {
                obj.pop();
             } else {
                 obj.push(arr[i]);
             }
        }
        String[] disp = obj.getarray();
        for (int j = 0; j < disp.length; j++) {
            if (disp[j] != null) {
               System.out.println(disp[j]);
            }
        }

    }
    /**
     * The actual program starts with this main method and calls java method
     * for further operations.
     * @param args String arguements.
     */
    public static void main(final String[] args) {
        String s = "it was - the best - of times - - - it was - the - -";
        java(s);
    }
}
