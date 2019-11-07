/**
 * . finding MinPQ
 */
public class MinPQ {
    /**
     * double datatype array which stores elements.
     */
    public double[] pq;
    /**
     * integer N which stores the size the array.
     */
    public int N;
    /**
     * declaring the size of the array.
     * @param capacity size.
     */
    public MinPQ(final int capacity) {
        pq = new double[capacity];
        N = 0;
     }
    /**
     * is empty or not.
     * @return true or false.
     */
     public boolean isEmpty() {
         return N == 0;
     }
    /**
     * inserting an element into the array.
     * @param x element.
     */
     public void insert(final double x) {
        pq[++N] = x;
        swim(N);
    }
    /**
     * find the sorted oreder using swim.
     * @param k represents the element
     */
     public void swim(final int k) {
            while (k > 1 && pq[k] < pq[k / 2]) {
            exch(k, k / 2);
            k = k / 2;
            }
     }
    /**
     * representing in order using sink.
     * @param k represents the element.
     */
     public void sink(final int k) {
        while (2 * k <= N) {
        int j = 2 * k;
        if (j < N && (pq[j] > pq[j + 1])) {
             j++;
        }
        if (pq[k] < pq[j]) {
            break;
        }
         exch(k, j);
        k = j;
        }
     }
    /**
     * exchanges between the elements.
     * @param i one element.
     * @param j another element.
     */
    private void exch(final int i, final int j) {
        double t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        }
    /**
     * deletes the element in an array.
     * @return returns the minimum.
     */
    public double delMin() {
        double min = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = 0d;
        return min;
        }
    }
