package com.company;

import java.util.LinkedList;
import java.util.Queue;

class BTree2 {
    private class Node {
        private Node left;
        private Node right;
        private Integer value;
        Node(Integer value) { this.value = value; }
    }
    private Node root;
    BTree2() {root = null; }

    void BFS() {
        if (this.root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);

        while (!q.isEmpty()) {
            Node node = q.peek();
            System.out.print(node.value + "\t");
        }
    }

    void levelSearch() {
        if (this.root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);

        while (!q.isEmpty()) {
            int count = q.size();

            while (count > 0) {
                Node node = q.peek();
                System.out.print(node.value + "\t");
                q.remove();
                if (node.left != null) {
                   q.add(node.left);
                }
                if (node.right != null) {
                   q.add(node.right);
                }
                count--;
            }
            System.out.println();
        }
    }



    void insert(Integer value) {
        this.root = insert(this.root, value);
    }
    private Node insert(Node node, Integer value) {
        if (node == null) {
            return new Node(value);
        } else {
            if (node.value < value) {
                node.right = insert(node.right, value);
            }
            if (node.value > value) {
                node.left = insert(node.left, value);
            }
        }
        return node;
    }

    void printInOrder() {
        printInOrder(this.root);
    }
    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }

    void remove(Integer value) {
        this.root = remove(this.root, value);
    }
    private Node remove(Node node, Integer value) {
        if (node == null) {
            return null;
        } else if (value < node.value) {
            node.left = remove(node.left, value);
        } else if (value > node.value) {
            node.right = remove(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                System.out.println("deleting 1 " + value);
                return null;
            } else if (node.right == null) {
                System.out.println("deleting 2 " + value);
                return node.left;
            } else if (node.left == null) {
                System.out.println("deleting 3 " + value);
                return node.right;
            } else {
                Integer minValue = minValue(node);
                node.value = minValue;
                node.right = remove(node.right, minValue);
                System.out.println("deleting 4 " + value);
            }
        }
        return node;
    }

    void height() {
        System.out.println("Height " + height(this.root));
    }
    private Integer height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private Integer minValue(Node node) {
        if (node.left != null) {
            return minValue(node.left);
        }
        return node.value;
    }
}
