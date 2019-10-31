import java.util.Arrays;
/**
 * shows the frequency of the pairs of the numbers.
 */
public final class Pairs {
    /**
     * private constructor.
     */
    private pairs() {
        //check style
    }
    /**
     * this method prints the frequency of the pairs of the numbers.
     * @param array stores the elemnts.
     */
    public static void pair(final int[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] == array[j + 1]) {
                count += 1;
            }
        }
        System.out.println(count);
    }
    /**
     * The program starts from this method and calls the pair method for
     * further operations.
     * @param args string arguements.
     */
    public static void main(final String[] args) {
        int[] array = {2, 4, 7, 5, 2, 9, 1, 5};
        pair(array);
    }
}
