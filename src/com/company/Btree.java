package com.company;

public class Btree {
    private TreeNode root;

    public Btree() {
        root = null;
    }

    public void preOrderTraverse() {
        preOrderTraverse(root);
    }
    public void postOrderTraverse() {
        postOrderTraverse(root);
    }
    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    private void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    private void postOrderTraverse(TreeNode root) {
        if (root != null) {
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
            System.out.print(root.value + " ");
        }
    }

    private void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.value + " ");
            inOrderTraverse(root.right);
        }
    }

    public void insertNode(Integer val) {
        root = insertNode(root,val);
    }

    private TreeNode insertNode(TreeNode root, Integer val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.value) {
            root.left = insertNode(root.left, val);
        }
        if (val > root.value) {
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    class TreeNode {
        Integer value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(Integer value) {
            this.value = value;
        }
    }
}
