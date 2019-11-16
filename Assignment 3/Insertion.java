public class Insertion {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (great(arr[j], arr[j - 1])) {
                    exch(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    private static boolean great(final Comparable v, final Comparable w) {
        // System.out.println(v);
        // System.out.println(w);
        return v.compareTo(w) > 0;
    }
    private static void exch(Comparable[] arr, final int i, final int j) {
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
}
