package dsalgo.trees;

// Symbol table implementation using binary search tree
public class BST<Key extends Comparable,Value> {
    class Node {
        private Key key;
        private Value val;
        private Node left, right;
        Node(Key key,Value val){
            this.key = key;
            this.val = val;
        }
    }

    private Node root;

    public void put(Key key, Value val){
        if (key==null)
            throw new IllegalArgumentException();
        root = put(root, key, val);
    }

    private Node put(Node x,Key key, Value val){
        if (x == null) return new Node(key,val);
        int cmp = key.compareTo(x.key);
        if (cmp>0) {
            x.right = put(x.right, key, val);
        }
        else if (cmp<0) {
            x.left = put(x.left, key, val);
        }
        else if (cmp==0) {
            x.val = val;
        }
        return x;
    }

    private Value get(Key key){
        Node x = root;
        while(x!=null) {
            int cmp = key.compareTo(x.key);
            if (cmp > 0) {
                x = x.right;
            } else if (cmp < 0) {
                x = x.left;
            } else if (cmp == 0) {
                return x.val;
            }
        }
        return null;
    }
    public static void main(String args[]){
        BST<Integer,String> bst = new BST<Integer,String>();
        bst.put(1,"Sagar");
        bst.put(4,"Bhishma");
        bst.put(3,"cxcx");
        bst.put(2,"neo");
        bst.put(5,"aryan");
        bst.put(5,"Arya");


        System.out.println(bst.get(5));
        System.out.println(bst.get(1));
        System.out.println(bst.get(2));
        try {
            bst.put(null, "value");
        } catch (IllegalArgumentException ilE) {
            System.out.println("Null key not allowed" + ilE.toString());
        }
        System.out.println("This should get null =? " + bst.get(6));

    }
}
