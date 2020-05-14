package com.leetcodetest.初级算法.动态规划.最大子序和;

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int cSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (cSum < 0) {
                cSum = num;
            } else {
                cSum += num;
            }
            if (cSum > maxSum) {
                maxSum = cSum;
            }
        }
        return maxSum;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}