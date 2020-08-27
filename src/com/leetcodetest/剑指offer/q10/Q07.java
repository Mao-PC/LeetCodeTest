package com.leetcodetest.剑指offer.q10;

import com.leetcodetest.初级算法.树.TreeNode;

public class Q07 {
    static class Solution {

        int[] preorder = null;
        int[] inorder = null;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0 || preorder.length != inorder.length) return null;

            this.preorder = preorder;
            this.inorder = inorder;
            // 根节点
            TreeNode node = new TreeNode(preorder[0]);
            getTree(node,1, 0, inorder.length);

            return node;
        }

        private TreeNode getTree(TreeNode node, int rootIndex, int start, int end) {
            System.out.println(rootIndex + " " + start + " " + end);
            int value = preorder[rootIndex];
            TreeNode nextNode = new TreeNode(value);

            if (end - start == 1) {
                return nextNode;
            } else {
                rootIndex++;
                if (rootIndex == inorder.length) return nextNode;
                int index = getIndex(value);

                node.left = getTree(nextNode, rootIndex, start, index);
                node.right = getTree(nextNode, rootIndex, index, end);
            }
            return node;
        }

        private int getIndex(int value) {
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == value) return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node = s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(node);
    }
}
