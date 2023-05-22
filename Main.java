public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        int i = 0;
        while (i <= 15) {
            bst.put(i, "" + i);
            i++;
        }
        Iterable iterator = bst.iterator();
        for (Object elem : iterator) {
            System.out.println(elem);
        }
    }
}
