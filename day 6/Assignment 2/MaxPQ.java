public class MaxPQ {
public double [] pq;
public int N;

public MaxPQ(int capacity) {
    pq = new double[capacity];
    N = 0; 
 }

 public boolean isEmpty() {
     return N == 0; 
 }

 public void insert(double x) {
    pq[++N] = x;
    swim(N);
}

 public void swim(int k) {
        while (k > 1 && (pq[k] > pq[k/2])) {
        exch(k, k/2);
        k = k/2;
        }       
 }

 public void sink(int k) {
    while (2 * k <= N) {
    int j = 2 * k;
    if (j < N && (pq[j] < pq[j + 1])) j++;
    if (pq[k] > pq[j]) break;
     exch(k, j);
    k = j;
    }
 }

private void exch(int i, int j) {
    double t = pq[i];
    pq[i] = pq[j];
    pq[j] = t;
    }

public double delMax() {
    double max = pq[1];
    exch(1, N--);
    sink(1);
    pq[N+1] = 0d;
    return max;
    } 
}