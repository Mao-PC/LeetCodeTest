package com.leetcodetest.剑指offer.q10;

import com.leetcodetest.初级算法.树.TreeNode;

public class Q07 {
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0 || preorder.length != inorder.length) return null;

            TreeNode node = null;


            for (int i = 0; i < preorder.length; i++) {
                int cNodeValue = preorder[i];
                if (i == 0) {
                    node = new TreeNode(cNodeValue);
                } else {
                    int
                }
            }

            return node;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
