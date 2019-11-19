import java.util.*;
/**
 * Main
 */
public class Main {

    

public static void main(String[] args) {
    String[] arr;
    Scanner sc = new Scanner(System.in);
    System.out.println("how many keys to insert");
    int kk = sc.nextInt();
    sc.nextLine();
    BinarySearchST obj = new BinarySearchST(kk);
    for (int j = 0; j < kk; j++) {
        System.out.println("enter key and value separated by single space");
        String str = sc.nextLine();
        //System.out.println(str);
        arr = str.split(" ");
        obj.put(arr[0], arr[1]);
    }
    System.out.println(Arrays.toString(obj.keys));
    System.out.println(Arrays.toString(obj.vals));
    }
}