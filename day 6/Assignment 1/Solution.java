/**
 * . is MinHeap or not.
 */
class Solution {
	/**
	 * this method checks where the array is in MinHeap or not.
	 * @param arr input array.
	 * @return returns true ot false.
	 */
	public static boolean isMinHeap(final double[] arr) {
		if (arr.length == 0) {
			return false;
		}
		if (arr.length == 1) {
			return true;
		}
		if (arr.length == 2 && arr[0] < arr[1]) {
			return true;
		}
		for (int i = 0; i < (arr.length - 2) / 2; i++) {
		if (arr[i] > arr[2 * i + 1] || arr[i] > arr[2 * i + 2]) {
				return false;
			}
		}
		return true;
}
}