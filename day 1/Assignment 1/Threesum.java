import java.util.*;
public class Threesum {
    int count = 0;
    int yy;
    public int  binary(int [] array, int x) {
        int low = 0;
        int high = array.length -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (x < array[mid]) {
                high = mid - 1;
            } else if (x > array[mid]) {
                low = mid + 1;
            } else {
                return array[mid];
            }
        } 
        return -1;
    }
    public static void main (String[] args) {
        int [] array = {30,-40,-20,-10,40,0,10,5};
        Arrays.sort(array);
        Threesum obj = new Threesum();
        for (int j = 0; j < array.length; j++) {
            for (int k = j + 1; k < array.length; k++) {
                obj.yy =  -(array[j] + array[k]);
                   int dd = obj.binary(array,obj.yy);
                   if (dd == obj.yy) {
                    if (array[j] < array[k]) {
                        if (array[k] < dd) {
                            obj.count +=1;
                        }
                    }
                   }  
            }
        }
        System.err.println(obj.count);
    }
}