package com.leetcodetest.初级算法.树.将有序数组转换为二叉搜索树;

import com.leetcodetest.初级算法.树.TreeNode;

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return getBST(nums, 0, nums.length-1);
    }

    private TreeNode getBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getBST(nums, start, mid - 1);
        node.right = getBST(nums, mid + 1, end);
        return node;
    }

}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19});
        System.out.println(TreeNode.preLoop(treeNode));
    }
}