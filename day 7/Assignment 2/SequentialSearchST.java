import java.util.NoSuchElementException;
/**.
 * This class describes a sequential search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SequentialSearchST<Key extends Comparable<Key>, Value> {
    /**.
     * { link list holding keys and values }
     */
    LinkedList link = new LinkedList();

    /**.
     * { inserts key value in link }
     *
     * @param      k     { key }
     * @param      v     { value }
     * O(constant)
     */
    void put(final Key k, final Value v) {
        if (k == null) throw new IllegalArgumentException("Argument is null");
        else {
            link.add(k, v);
        }
    }
    /**.
     * Gets the specified k.
     *
     * @param      k     { key value }
     *
     * @return     { value of corresponding key }
     * O(constant)
     */
    Value get(final Key k) {
        if (k == null) throw new IllegalArgumentException("Argument is null");
        else {
            Node temp = link.contains(k);
            if (temp == null) {
                return null;
            }
            return (Value) temp.value;
        }
    }
    /**.
     * { inserts all keys in queue }
     *
     * @return     { queue }
     * O(n)
     */
    Iterable<Key> keys() {
        Queue<Key> que = new Queue<Key>();
        Node temp = link.head;
        while (temp != null) {
            que.enqueue((Key) temp.key);
            temp = temp.reference;
        }
        return que;
    }
}