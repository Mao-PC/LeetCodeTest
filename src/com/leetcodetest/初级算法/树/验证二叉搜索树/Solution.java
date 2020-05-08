package com.leetcodetest.初级算法.树.验证二叉搜索树;

import com.leetcodetest.初级算法.树.TreeNode;

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isVaild(root, root.val, 0);
    }

    public boolean isVaild(TreeNode root, int mid, int lORr) {
        if (root == null) return true;

        boolean flag = true;

        if (root.left != null) {
            if (lORr == 1 && mid > root.left.val) {
                return false;
            }
            flag = root.left.val < root.val && flag;
        }

        if (root.right != null){
            if (lORr == -1 && mid < root.right.val) {
                return false;
            }
            flag = root.right.val > root.val && flag;
        }
        return flag && isVaild(root.left, mid, -1) && isVaild(root.right, mid, 1);
    }


}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValidBST(TreeNode.getTree()));
        System.out.println(s.isValidBST(TreeNode.getTree(5,1,4,null,null,3,6)));
        System.out.println(s.isValidBST(TreeNode.getTree(10,5,15,null,null,6,20)));
    }
}