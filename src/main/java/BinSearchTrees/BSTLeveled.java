package BinSearchTrees;


import java.util.*;

public class BSTLeveled<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    public Node getNodeByKey(Key key) {
        return getNodeByKey(root, key);
    }

    private Node getNodeByKey(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return getNodeByKey(node.left, key);
        else if (cmp > 0) return getNodeByKey(node.right, key);
        else return node;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.size;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null) return new Node(key, val, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else node.val = val;
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }


    public void printLevel(Node node) {
        int height = height(node);
        printLevel(Collections.singletonList(node), 1, height);
    }

    public void printLevel(List<Node> nodes, int currentLevel, int height) {
        boolean nullsOnly = nodes.stream().noneMatch(Objects::nonNull);
        if (nodes.isEmpty() || nullsOnly)    //may all be nulls
            return;

        int levelsLeft = height - currentLevel;
        int lines = (int) Math.pow(2, Math.max(levelsLeft - 1, 0));
        int spaces = (int) Math.pow(2, levelsLeft) - 1;
        int spacesInBetween = (int) Math.pow(2, (levelsLeft + 1)) - 1;

        for (int i = 0; i < spaces; i++)
            System.out.print(" ");

        List<Node> nextLevelNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.key);
                nextLevelNodes.add(node.left);
                nextLevelNodes.add(node.right);
            } else {
                nextLevelNodes.add(null);
                nextLevelNodes.add(null);
                System.out.print(" ");
            }

            for (int i = 0; i < spacesInBetween; i++)
                System.out.print(" ");
        }

        System.out.println("");

        for (int i = 1; i <= lines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                for (int k = 0; k < spaces - i; k++)
                    System.out.print(" ");
                if (nodes.get(j) == null) {
                    for (int k = 0; k < lines * 2 + i + 1; k++)
                        System.out.print(" ");
                    continue;
                }
                if (nodes.get(j).left != null)
                    System.out.print("/");
                else System.out.print(" ");

                for (int k = 0; k < i * 2 - 1; k++)
                    System.out.print(" ");

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else System.out.print(" ");

                for (int k = 0; k < lines * 2 - i; k++)
                    System.out.print(" ");
            }
            System.out.println("");
        }
        printLevel(nextLevelNodes, currentLevel + 1, height);
    }

}



