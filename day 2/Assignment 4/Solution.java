import java.util.*;
final class Solution {
	/**
	 * ...
	 */
	private Solution() {
		// for check style.
	}
	/**
	 * In this method we are using queue and related methods
	 *  like add and remove.
	 * @param a input which implies number of numbers.
	 * @param b input which implies nth of number.
	 * @return returns string.
	 */
	public static String Josephus(final int a, final int b) {
		// fill you code Here
		Queue<Integer> xyz = new LinkedList<>();
		String str = "";
		for (int i = 0; i < a; i++) {
			xyz.add(i);
		}
		while (xyz.size() > 1) {
			for (int j = 0; j < b - 1; j++) {
				int tem = xyz.remove();
				xyz.add(tem);
			}
			str = str + xyz.remove() + " ";
		}
		str = str + xyz.remove();
		return str;
}
}
