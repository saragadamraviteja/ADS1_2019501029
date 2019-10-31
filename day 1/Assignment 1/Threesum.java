import java.util.*;
/**
 * IN this class we are performing three sum method
 * which the sum of the values is equal to zero.
 */
public class ThreeSum {
    /**
     * integer count stores the count value.
    */
    private int count = 0;
    /**
     * yy is used to store the sum of the two values.
     */
    private int yy;
    /**
     *
     * @param array array of integers it stores.
     * @param x key value it stores.
     * @return it returns the mid value value of the array.
     */
    public int  binary(final int[] array, final int x) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
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
    /**
     * this ,method performes operations and shows the result
     *  as it removes the duplicates. and shows the count.
     * @param array stores array of elements
     */
    public static void threesum(final int[] array) {
        Arrays.sort(array);
        ThreeSum obj = new ThreeSum();
        for (int j = 0; j < array.length; j++) {
            for (int k = j + 1; k < array.length; k++) {
                obj.yy =  -(array[j] + array[k]);
                   int dd = obj.binary(array, obj.yy);
                   if (dd == obj.yy) {
                    if (array[j] < array[k]) {
                        if (array[k] < dd) {
                            obj.count += 1;
                        }
                    }
                   }
            }
        }
        System.err.println(obj.count);
    }
/**
 * this is the main method where the program starts.
 * @param args arguements of the string.
 * this method is used for sending the input array to the threesumm method.
 */
    public static void main(final String[] args) {
        int[] array = {30, -40, -20, -10, 40, 0, 10, 5};
        threesum(array);
    }
}
