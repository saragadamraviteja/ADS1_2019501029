/**
 * MainSol
 */
public class MainSol {

    public static void main(String[] args) {
        BST<Integer, Integer> objj = new BST();
        objj.put(4, 7);
        objj.put(2, 2);
        objj.put(8, 3);
        objj.put(1, 8);
        System.out.println(objj.isOrdered(objj.root, 5,8));
        System.out.println(objj.isOrdered(objj.root, 1,8));
    }
}