import java.util.*;
public class Index {
    public static void main(String [] args) {
        int [] a = {1,5,7,9,3,4,3,5,1};
        Arrays.sort(a);
        int key = 5;      
               int lo = 0;
               int  hi = a.length - 1;
               while (lo <= hi) {         
                    int mid = lo + (hi - lo) / 2;      
                       if (key < a[mid]) {
                            hi = mid - 1;
                       }     
                         else if (key > a[mid]) {
                             lo = mid + 1;
                         }      
                          else if (mid != 0 && a[mid] == a[mid - 1]) {
                              hi = mid - 1;
                               } else {
                                   System.out.println(a[mid]);
                                   break;
                               }
                  }
                  
    }
}