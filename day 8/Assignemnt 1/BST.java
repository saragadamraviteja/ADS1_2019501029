public class BST {

public void put(Key key, Value val) {
    root = put(root, key, val);
}

public Book put(Book x, Key key, value val) {
    if (x == null) {
        return new Book(key, val);
    }
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
        x.left = put(x.left, key, val);
    } else if (cmp > 0) {
        x.right = put(x.right, key, val);
    } else if (cmp == 0) {
        x.val = val;
    }
    return x;
}

public Value get(Key k) {
    Book x = root;
    while (x != null) {
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x = x.left;
        } else if (cmp > 0) {
            x = x.right;
        } else if (cmp == 0) {
            return x.val;
        }
    }
}

public Keymin()
}

