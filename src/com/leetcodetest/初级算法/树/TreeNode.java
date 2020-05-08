package com.leetcodetest.初级算法.树;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode getTree(int... values){
        if (values == null || values.length == 0) return null;
        TreeNode tree = new TreeNode(values[0]);
        TreeNode[] nodes = new TreeNode[values.length];
        nodes[0] = tree;
        for (int i = 1; i < values.length; i++) {
            for (int j = 0; j < nodes.length; j++) {
                if (nodes[j] != null) {
                    TreeNode node = new TreeNode(values[i]);
                    nodes[j].left = node;
                }
            }
        }
    }
}