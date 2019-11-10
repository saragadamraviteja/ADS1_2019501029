/**.
 * List of my linkedlists.
 */

public class LinkedList<Key extends Comparable<Key>, Value> {

    /**.
     * { head of linked list }
     */

    Node head;

    /**.
     * Constructs a new instance.
     */

    public LinkedList() {
        head = null;
    }

    /**.
     * { adds key and value to linked list }
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void add(final Key key, final Value value) {
        if (head == null) {
            head = new Node(key, value);
            return;
        }
        Node temp = head;
        while (temp.reference != null) {
            if ((temp.key.equals(key))) {
                temp = temp.reference;
            } else {
                temp.value = value;
                return;
            }
        }
        temp = new Node(key, value);
        temp.reference = head;
        head = temp;
    }

    /**.
     * Returns true if this list contains the specified element.
     *
     * @param key  The data
     *
     * @return { description_of_the_return_value }
     * O(n)
     */

    public Node contains(final Key key) {
        Node tempo = head;
        Node temp = null;
        while (tempo.reference != null) {
            if (tempo.reference.key.compareTo(key) == 0) {
                temp = tempo.reference;
                tempo.reference = temp.reference;
                temp.reference = null;
            }
            tempo = tempo.reference;
        }
        tempo.reference = temp;
        return temp;
    }

    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     * O(n)
     */
    public String toString() {
        if (head == null) {
            return "LinkedList is empty";
        }

        String output = "";
        Node current = head;
        while (current != null) {
            String temp = "[" + current.key + "]";
            output += temp;
            current = current.reference;
        }
        return output;
    }
}
