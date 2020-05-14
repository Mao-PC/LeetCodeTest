package com.leetcodetest.初级算法.动态规划.打家劫舍;

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // res[i] 代表: 在 i 之前获得的最高利益
        int[] res = new int[nums.length + 1];

        res[0] = 0;
        res[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i - 1]);
        }

        return res[nums.length];
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{1, 2, 3, 1}));
        System.out.println(s.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(s.rob(new int[]{2, 7, 9, 3, 1, 3}));
        System.out.println(s.rob(new int[]{226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55, 122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223, 188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124}));
    }
}