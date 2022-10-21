package BalancedBinSearchTrees;

public class RedBlackBSTVerified<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    private int getSize(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Key key) {
        return (getValue(key) != null);
    }

    private boolean contains(Node node, Key key) {
        return (getValue(node, key) != null);
    }

    private boolean isRed(Node node) {
        if (node == null) return false;
        return (node.color == RED);
    }

    public Value getValue(Key key) {
        return getValue(root, key);
    }

    private Value getValue(Node node, Key key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else return node.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
        assert check();
    }

    public void delete(Key key) {
        if (!contains(key)) {
            System.err.println("No key " + key);
            return;
        }

        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = delete(root, key);
        if (!isEmpty())
            root.color = BLACK;
        assert check();
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return null;

        if (!isRed(node.left) && !isRed(node.left.left))
            node = moveRedLeft(node);

        node.left = deleteMin(node.left);
        return balance(node);
    }

    public Key min() {
        if (isEmpty())
            return null;
        return min(root).key;
    }

    private Node min(Node node) {
        assert node != null;
        if (node.left == null)
            return node;
        else
            return min(node.left);
    }

    private Node moveRedLeft(Node node) {
        assert (node != null);
        assert isRed(node) && !isRed(node.left) && !isRed(node.left.left);

        flipColors(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }
        return node;
    }

    private Node moveRedRight(Node node) {
        assert (node != null);
        assert isRed(node) && !isRed(node.right) && !isRed(node.right.left);
        flipColors(node);
        if (isRed(node.left.left)) {
            node = rotateRight(node);
        }
        return node;
    }

    private Node balance(Node node) {
        assert (node != null);

        if (isRed(node.right))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            flipColors(node);
        node.size = getSize(node.left) + getSize(node.right) + 1;
        return node;
    }

    private Node delete(Node node, Key key) {
        assert contains(node, key);

        if (key.compareTo(node.key) < 0) {
            if (!isRed(node.left) && !isRed(node.left.left))
                node = moveRedLeft(node);
            node.left = delete(node.left, key);
        } else {
            if (isRed(node.left))
                node = rotateRight(node);
            if (key.compareTo(node.key) == 0 && (node.right == null))
                return null;
            if (!isRed(node.right) && !isRed(node.right.left))
                node = moveRedRight(node);
            if (key.compareTo(node.key) == 0) {
                node.val = getValue(node.right, min(node.right).key);
                node.key = min(node.right).key;
                node.right = deleteMin(node.right);
            } else node.right = delete(node.right, key);
        }
        return balance(node);
    }

    private Node rotateLeft(Node node) {
        assert (node != null) && isRed(node.right);
        Node newnode = node.right;
        node.right = newnode.left;
        newnode.left = node;
        newnode.color = newnode.left.color;
        newnode.left.color = RED;
        newnode.size = node.size;
        node.size = getSize(node.left) + getSize(node.right) + 1;
        return newnode;
    }

    private Node rotateRight(Node node) {
        assert (node != null) && isRed(node.left);
        Node newnode = node.left;
        node.left = newnode.right;
        newnode.right = node;
        newnode.color = newnode.right.color;
        newnode.right.color = RED;
        newnode.size = node.size;
        node.size = getSize(node.left) + getSize(node.right) + 1;
        return newnode;
    }

    private void flipColors(Node node) {
        assert (node != null) && (node.left != null) && (node.right != null);
        assert (!isRed(node) && isRed(node.left) && isRed(node.right))
                || (isRed(node) && !isRed(node.left) && !isRed(node.right));
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null) return new Node(key, val, RED, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else node.val = val;

        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            flipColors(node);
        node.size = getSize(node.left) + getSize(node.right) + 1;

        return node;
    }

    public boolean check() {
        if (!isBST()) System.out.println("Not in symmetric order");
        if (!is23()) System.out.println("Not a 2-3 tree");
        if (!isBalanced()) System.out.println("Not balanced");
        return isBST() && is23() && isBalanced();
    }

    private boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node node, Key min, Key max) {
        if (node == null) return true;
        if (min != null && node.key.compareTo(min) <= 0) return false;
        if (max != null && node.key.compareTo(max) >= 0) return false;
        return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
    }

    private boolean is23() {
        return is23(root);
    }

    private boolean is23(Node node) {
        if (node == null) return true;
        if (isRed(node.right)) return false;
        if (node != root && isRed(node) && isRed(node.left)) return false;
        return is23(node.left) && is23(node.right);
    }

    private boolean isBalanced() {
        int black = 0;
        Node node = root;
        while (node != null) {
            if (!isRed(node)) black++;
            node = node.left;
        }
        return isBalanced(root, black);
    }

    private boolean isBalanced(Node node, int black) {
        if (node == null) return black == 0;
        if (!isRed(node)) black--;
        return isBalanced(node.left, black) && isBalanced(node.right, black);
    }

}