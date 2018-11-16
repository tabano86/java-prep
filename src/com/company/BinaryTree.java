package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTree {
    private Node root;

    BinaryTree() {
        root = null;
    }

    void inOrder() {
        inOrder(root);
    }

    void breadthFirst() {
        breadthFirst(this.root);
    }

    private void breadthFirst(Node root) {
        if (root == null) {
            return;
        }
        List<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node n = queue.remove(0);
            System.out.print(n.value + " ");
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    private void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    void insertNode(Integer value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, Integer value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        }
        if (value > root.value){
            root.right = insertNode(root.right, value);
        }
        return root;
    }


    class Node {
        Integer value;
        Node left;
        Node right;

        Node(Integer value) {
            this.value = value;
        }
    }
}
