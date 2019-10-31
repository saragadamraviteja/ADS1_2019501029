import java.util.*;
/**
 * sorting of the elements in two arrays and displaying them
 * into single sorted array.
 */
public class Sortedarray {
    /**
     * in this method we are storing the sorted elements of two arrays in
     * single array.
     * @param x array which stores elements.
     * @param y array which stores elements.
     */
    public static void sortedarray(final int[] x, final int[] y) {
        int[] z = new int[x.length + y.length];
        int j = 0;
        int k = 0;
        int l = 0;
        int flag = 0;
        for (int i = 0; i < z.length - 1; i++) {
            if (x[j] <= y[k]) {
                z[l] = x[j];
                j += 1;
                l += 1;
                if (x.length == j)  {
                    flag = 1;
                    break;
                }
            } else {
                z[l] = y[k];
                k += 1;
                l += 1;
                if (y.length == k) {
                    flag = 2;
                    break;
                }
            }
         }
         if (flag == 1) {
             int j1 = j;
             for (int s = k; s < z.length - j1; s++) {
                 z[j + k] = y[s];
                 j++;
             }
         } else if (flag == 2) {
             int k1 = k;
             for (int r = j; r < z.length - k1; r++) {
                 z[k + j] = x[r];
                 k++;
             }
         }
         System.out.println(Arrays.toString(z));
    }
    /**
     * from this method the program starts and it calls the sortedarray method
     * where further operations takes place.
     * @param args string arguements.
     */
    public static void main(final String[] args) {
        int[] x = {1, 3, 5, 7};
        int[] y = {8, 9, 10, 11};
        sortedarray(x, y);
    }
}
