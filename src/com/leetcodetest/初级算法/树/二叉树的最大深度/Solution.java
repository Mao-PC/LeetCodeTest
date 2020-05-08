package com.leetcodetest.初级算法.树.二叉树的最大深度;

import com.leetcodetest.初级算法.树.TreeNode;

import java.util.Arrays;

/**
 * 这个不是好解法, 清空Python版的解法
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return getMaxDepth(new TreeNode[]{root}, 1);
    }

    private int getMaxDepth(TreeNode[] nodes, int depth) {

        if (nodes == null || nodes.length == 0) return depth;

        TreeNode[] treeNodes = new TreeNode[nodes.length * 2];
        int index = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                if (nodes[i].left != null) {
                    treeNodes[index] = nodes[i].left;
                    index++;
                }
                if (nodes[i].right != null) {
                    treeNodes[index] = nodes[i].right;
                    index++;
                }
            }
        }
        if (index != 0) depth++;
        // 去除 null
        TreeNode[] treeNodes1 = Arrays.copyOf(treeNodes, index);
        return getMaxDepth(treeNodes1, depth);
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree(3, 9, 20, null, null, 15, 7);
        System.out.println(new Solution().maxDepth(tree));
    }
}