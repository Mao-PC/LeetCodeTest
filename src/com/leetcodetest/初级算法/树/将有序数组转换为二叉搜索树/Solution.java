package com.leetcodetest.初级算法.树.将有序数组转换为二叉搜索树;

import com.leetcodetest.初级算法.树.TreeNode;

class Solution {

    private int[] nums = null;
    private int length = 0;
    private int center = 0;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        this.nums = nums;
        this.length = nums.length;
        this.center = nums.length / 2;
        TreeNode node = new TreeNode(nums[nums.length / 2]);
        getBST(node, 0);
        return node;
    }

    private void getBST(TreeNode node, int distance) {

        if (center-distance < 0 || distance + center >= length) return;

        if (center - distance - 2 >= 0) {
            node.left = new TreeNode(nums[center - distance - 2]);
            getBST(node.left, distance - 2);
        } else if (center - distance - 1 >= 0) {
            node.left = new TreeNode(nums[center - distance - 2]);
            return;
        }
        if (center + distance + 2 < length) {
            node.right = new TreeNode((nums[center + distance + 2]));
            getBST(node.right, distance + 2);
        } else if (center + distance + 1 < length) {
            node.right = new TreeNode((nums[center + distance + 1]));
            return;
        }
    }

}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}