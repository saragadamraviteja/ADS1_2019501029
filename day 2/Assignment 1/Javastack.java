import java.util.*;

public class Javastack {
    public static void main(String [] args) {
        String s = "it was - the best - of times - - - it was - the - -";
        String [] arr = s.split(" ");
        Stack1 obj = new Stack1(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("-")) {
                obj.pop();
             } else {
                 obj.push(arr[i]);
             }
        }
        String [] disp = obj.getarray();
        // System.out.println(disp);
        // System.out.println(Arrays.toString(obj.getarray()));
        for (int j = 0; j < disp.length; j++) {
            if (disp[j] != null) {
               System.out.println(disp[j]);
            }
        }
    }
}
