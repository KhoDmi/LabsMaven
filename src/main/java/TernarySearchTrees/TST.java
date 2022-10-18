package TernarySearchTrees;

public class TST<Value> {
    private int size;
    private Node root;

    private class Node {
        private char c;
        private Node left, mid, right;
        private Value val;
    }

    public int size() {
        return size;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public void clear() {
        this.root = null;
    }

    public boolean containsNullKey(String key) {
        return get(root, key, 0) != null;
    }

    public Value get(String key) {
        if (key == null || key.length() == 0)
            throw new RuntimeException("illegal key");
        Node node = get(root, key, 0);
        if (node == null)
            return null;
        return node.val;
    }

    private Node get(Node node, String key, int pos) {
        if (node == null)
            return null;
        char c = key.charAt(pos);
        if (c < node.c)
            return get(node.left, key, pos);
        else if (c > node.c)
            return get(node.right, key, pos);
        else if (pos < key.length() - 1)
            return get(node.mid, key, pos + 1);
        else return node;
    }


    public void put(String s, Value val) {
        if (!contains(s))
            size++;
        root = put(root, s, val, 0);
    }

    private Node put(Node node, String s, Value val, int pos) {
        char c = s.charAt(pos);
        if (node == null) {
            node = new Node();
            node.c = c;
        }
        if (c < node.c)
            node.left = put(node.left, s, val, pos);
        else if (c > node.c)
            node.right = put(node.right, s, val, pos);
        else if (pos < s.length() - 1)
            node.mid = put(node.mid, s, val, pos + 1);
        else node.val = val;
        return node;
    }

    public int numOfSubstrings(String s, int L) {
        this.clear();
        int num = 0;
        String subs;
        for (int i = 0; i < s.length() - L; i++) {
            subs = s.substring(i, i + L);
            if (this.containsNullKey(subs))
                continue;
            this.put(subs, null);
            num++;
            System.out.print("Unique key " + num + ": ");
            System.out.println(subs);
        }
        this.clear();
        System.out.println("Number of " + L + "-letter substrings in string " + s + " is: " + num);
        return num;
    }
}

