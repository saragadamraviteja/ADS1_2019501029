/**
 * . InsertionSort
 */
public class InsertionSort {

    /**
     * sorts the array
     *
     * @param arr array that has to be sorted
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (great(arr[j], arr[j - 1])) {
                    exch(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * . great method checks if the object is greater or not
     *
     * @param v object
     * @param w oject
     * @return true if greater, false if not
     */
    private static boolean great(final Comparable v, final Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * . exch method swaps the two objects at the positions passed
     *
     * @param arr array
     * @param i   position1
     * @param j   position2
     */
    private static void exch(Comparable[] arr, final int i, final int j) {
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
}
