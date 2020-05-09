package com.leetcodetest.初级算法.树.验证二叉搜索树;

import com.leetcodetest.初级算法.树.TreeNode;

class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isVaild(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     *
     * @param node 每次判断的node
     * @param min 这个 node 下的最小值
     * @param max 这个 node 下的最小值
     * @return
     */
    public boolean isVaild(TreeNode node, long min, long max) {
        if (node == null) return true;

        boolean flag = true;

        if (node.left != null) {
            Integer val = node.left.val;

            flag = val < node.val && val > min && val < max && flag;
        }

        if (node.right != null){
            Integer val = node.right.val;
            flag = val > node.val && val > min && val < max && flag;
        }
        return flag && isVaild(node.left, min, node.val) && isVaild(node.right, node.val, max);
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValidBST(TreeNode.getTree(Integer.MIN_VALUE, null, Integer.MAX_VALUE))); // true
        System.out.println(s.isValidBST(TreeNode.getTree(3,1,5,0,2,4,6))); // true
        System.out.println(s.isValidBST(TreeNode.getTree(3, 1, 5, 0, 2, 4, 6, null, null, null, 3))); // false
        System.out.println(s.isValidBST(TreeNode.getTree(5, 1, 4, null, null, 3, 6))); // false
        System.out.println(s.isValidBST(TreeNode.getTree(10, 5, 15, null, null, 6, 20))); // false
    }
}