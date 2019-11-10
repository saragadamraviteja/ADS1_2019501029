/**
 * BST implementation.
 * @author raviteja.
 * @param <Key> keys.
 * @param <Value> values.
 */
public class BST<Key extends Comparable<Key>, Value> {
    /**
     * node type root 
     */
    private Node root;
    /**
     * Node constructor and its fields.
     */
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size1) {
            this.key = key;
            this.val = val;
            this.size = size1;
            left = null;
            right = null;
        }
    }
    /**
     * inserting keys and values.
     * @param key specific key.
     * @param val specific value.
     */
    public void put(Key key, Value val) {
        if (key == null) {
            return ;
        }
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }
    /**
     * inserting elements into array.
     * @param x x Node type
     * @param key key
     * @param val value
     * @return return Node type.
     */
    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    /**
     * search an element.
     * @param key key
     * @return return Value.
     */
    public Value get(Key key) {
        return get(root, key);
    }
    /**
     * getting an element from an array.
     * @param x node x type
     * @param key key
     * @return returns Value
     */
    private Value get(Node x, Key key) {
        if (key == null) {
            return null;
        }
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
    /**
     * is empty or not .
     * @return true or false.
     */ 
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * min key from an array.
     * @return minimum key.
     */
    public Key min() {
        if (isEmpty()) {
            return  null;
        }
        return min(root).key;
    } 
    /**
     * finding an minimum key.
     * @param x Node type.
     * @return minimum element.
     */
    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 
    /**
     * finding an maximum element.
     * @return maximum key.
     */
    public Key max() {
        if (isEmpty()) {
            return null;
        }
        return max(root).key;
    } 
    /**
     * finding an maximum elemt 
     * @param x node type
     * @return maximum element.
     */
    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 
    /**
     * finding an floor.
     * @param key key
     * @return returns floor key
     */
    public Key floor(Key key) {
        if (key == null) {
            return null;
        }
        if (isEmpty()) {
            return null;
        }
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 
    /**
     * finding an floor
     * @param x node type
     * @param key key
     * @return return floor element.
     */ 
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key); 
        if (t != null) return t;
        else return x; 
    } 
    /**
     * finding an ceiling from an array.
     * @param key key.
     * @return returns ceiling key.
     */
    public Key ceiling(Key key) {
        if (key == null) {
            return null;
        }
        if (isEmpty()) {
            return null;
        }
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }
    /**
     * finding an ceiling from an array.
     * @param x node type
     * @param key key
     * @return returns ceiling item
     */
    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    } 
    /**
     * selects the key from an array.
     * @param k key
     * @return .
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            return null;
        }
        Node x = select(root, k);
        return x.key;
    }
    /**
     * selects the key from an array.
     * @param x node
     * @param k key
     * @return .
     */
    private Node select(Node x, int k) {
        if (x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 
    /**
     * delete minimum element.
     */
    public void deleteMin() {
        if (isEmpty()) {
            return;
        }
        root = deleteMin(root);
    }
    /**
     * delete min element.
     * @param x node
     * @return key.
     */
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * delete maximum key from an array.
     */
    public void deleteMax() {
        if (isEmpty()) {
            return;
        }
        root = deleteMax(root);
    }
    /**
     * delete max key.
     */
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * delete an key.
     * @param key .
     */
    public void delete(Key key) {
        if (key == null) {
            return;
        }
        root = delete(root, key);
    }
    /**
     * delete an key.
     */
    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 
    /**
     * rank of an array.
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }
    /**
     * rrank of an array.
     */
    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    }
    /**
     * size of an array.
     */
    public int size() {
        return size(root);
    }
    /**
     * size of an array.
     */
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
}

