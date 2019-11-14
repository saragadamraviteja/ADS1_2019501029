import java.util.*;
public class Farthest {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String yy = sc.nextLine();
        String[] arr = yy.split(" ");
        double min = Double.parseDouble(arr[0]);
        double max = Double.parseDouble(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (min > Double.parseDouble(arr[i])) {
                min = Double.parseDouble(arr[i]);
            }
            if (max < Double.parseDouble(arr[i])) {
                max = Double.parseDouble(arr[i]);
            }
        }
        System.out.println("[" + min + " " + max + "]");
        sc.close();
    }
}