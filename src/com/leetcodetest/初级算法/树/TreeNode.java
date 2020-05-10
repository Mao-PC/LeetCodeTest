package com.leetcodetest.初级算法.树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.IntFunction;

public class TreeNode {
    private String str = "";
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        val = x;
    }

    public static TreeNode getTree(Integer... values) {
        if (values == null || values.length == 0) return null;
        TreeNode node = new TreeNode(values[0]);
        getTree(1, values, new TreeNode[]{node});
        return node;
    }

    private static void getTree(int index, Integer[] values, TreeNode[] treeNodes) {
        if (index >= values.length) {
            return;
        } else {
            TreeNode[] nodes = new TreeNode[treeNodes.length * 2];
            for (int i = 0; i < treeNodes.length; i++) {
                if (treeNodes[i] != null) {
                    if (index < values.length && values[index] != null)
                        treeNodes[i].left = new TreeNode(values[index]);
                    if (index + 1 < values.length && values[index + 1] != null)
                        treeNodes[i].right = new TreeNode(values[index + 1]);

                    nodes[i * 2] = treeNodes[i].left;
                    nodes[i * 2 + 1] = treeNodes[i].right;
                }

                index += 2;
            }

            getTree(index, values, nodes);
        }
    }

    private void getList(List<List<Integer>> list, TreeNode node, int level) {
        if (node == null) return;

        if (list.size() == level) list.add(new ArrayList<>());
        list.get(level).add(node.val);

        getList(list, node.left, level + 1);
        getList(list, node.right, level + 1);
    }

    @Override
    public String toString() {
        this.print(this);
        return this.str;
    }

    private void print(TreeNode node) {
        if (node == null) return;
        str += node.val + "\t";
        print(node.left);
        print(node.right);
    }

    public static void main(String[] args) {
        System.out.println(getTree(3, 9, 20, null, null, 15, 7, null, null, null, null, 1, 2, 3, 4));
    }
}