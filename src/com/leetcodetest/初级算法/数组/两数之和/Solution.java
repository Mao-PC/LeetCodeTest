package com.leetcodetest.初级算法.数组.两数之和;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) return null;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i,j};
            }
        }
        return null;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(s.twoSum(nums, 9)));
    }
}