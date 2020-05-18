package com.leetcodetest.初级算法.其他.缺失数字;

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int standardSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            standardSum += i;
        }
        return standardSum + nums.length - sum;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}