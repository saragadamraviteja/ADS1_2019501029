import java.util.*;
public class Pairs {
    public static void main(String[] args ) {
        System.out.println("enter the number of elements into an array");
        Scanner ss = new Scanner(System.in);
        int inpt = ss.nextInt();
        int [] array = new int[inpt]; 
        for (int i = 0; i < array.length; i++) {
            System.out.println("enter the element into the array");
            int element = ss.nextInt();
            array[i] = element;
        }
        System.out.println(Arrays.toString(array));
        ss.close();
        // int [] array = new int[inpt];
        Arrays.sort(array);
        int count = 0;
        System.out.println(Arrays.toString(array));
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] == array[j+1]) {
                count +=1;
            }
        }
        System.out.println(count);
    }
    
}