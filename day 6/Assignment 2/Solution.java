/**
 * . dynamic median of an array of elements.
 * @author raviteja.
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
		if (min.getnum() - max.getnum() > 1) {
			max.insert(min.delMin());
		} else if (max.getnum() - min.getnum() > 1) {
			min.insert(max.delMax());
		}
		if (min.getnum() == max.getnum()) {
			medn = (min.getpq()[1] + max.getpq()[1]) / 2.0;
		} else if (min.getnum() - max.getnum() == 1) {
			medn = min.getpq()[1];
		} else if (max.getnum() - min.getnum() == 1) {
			medn = max.getpq()[1];
		}
		arr1[ss++] = medn;
		}
		return arr1;
	}
}
