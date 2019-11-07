/**
 * . dynamic median of an array of elements.
 */
class Solution {
/**
 * finding median of an elements in an array.
* @param arr input double type array.
* @return returns array of median values.
*/
public static double[] dynamicMedian(final double[] arr) {
	double medn = 0;
	double[] arr1 = new double[arr.length];
	MinPQ min = new MinPQ(arr.length + 1);
	MaxPQ max = new MaxPQ(arr.length + 1);
	int ss = 0;
	for (int i = 0; i < arr.length; i++) {
		if (arr[i] >= medn) {
			min.insert(arr[i]);
		} else {
			max.insert(arr[i]);
		}
		if (min.N - max.N > 1) {
			max.insert(min.delMin());
		} else if (max.N - min.N > 1) {
			min.insert(max.delMax());
		}
		if (min.N == max.N) {
			medn = (min.pq[1] + max.pq[1]) / 2.0;
		} else if (min.N - max.N == 1) {
			medn = min.pq[1];
		} else if (max.N - min.N == 1) {
			medn = max.pq[1];
		}
		arr1[ss++] = medn;
		}
		return arr1;
	}
}
