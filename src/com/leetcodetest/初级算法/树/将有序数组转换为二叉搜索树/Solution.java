package com.leetcodetest.初级算法.树.将有序数组转换为二叉搜索树;

import com.leetcodetest.初级算法.树.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums ==null || nums.length == 0) return null;
        TreeNode node = new TreeNode(nums[0]);
        sort(nums, 1, node, null, node, 0,0);
        return node;
    }

    private void sort(int[] nums, int index, TreeNode root, TreeNode parentNode, TreeNode cNode, int leftDepth, int rightDepth){
        if (index == nums.length -1) return;



        if (Math.abs(leftDepth-rightDepth) > 1) {

        } else {
            if (parentNode.right == null) {

            } else if (parentNode.left == null) {

            }
        }
    }
}

class Test {

}