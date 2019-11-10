/**
 * Class for node.
 */
public class Node<Key extends Comparable<Key>, Value> {
	
	/**.
	 * { key to value }
	 */
	
	Key key;
	
	/**.
	 * { value }
	 */
	
	Value value;
	
	/**.
	 * { stores reference to next node }
	 */

	Node reference = null;
	
	/**.
	 * Constructs a new instance.
	 *
	 * @param key  key
	 * @param  value value
	 * 
	 */
	
	public Node(final Key key1, final Value value1) {
		this.key = key1;
		this.value = value1;
	}
}
