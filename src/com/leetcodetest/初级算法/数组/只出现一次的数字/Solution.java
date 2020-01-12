package com.leetcodetest.初级算法.数组.只出现一次的数字;

class Solution {

    public int singleNumber(int[] nums) {

        if (nums.length == 1) return nums[0];

        // 排序
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int item = nums[i];
                    nums[i] = nums[j];
                    nums[j] = item;
                }
            }
        }

        int pre = 0;
        int next = 1;
        boolean preFlag = false;
        while (next < nums.length) {
            if (nums[pre] == nums[next]) {
                preFlag = true;

            } else {
                if (preFlag) {
                    preFlag = false;
                } else {
                    return nums[pre];
                }
            }
            pre++;
            next++;
        }

        return nums[nums.length - 1];
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 2, 1};
        System.out.println(solution.singleNumber(nums));
        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(solution.singleNumber(nums));
        nums = new int[]{1, 0, 1};
        System.out.println(solution.singleNumber(nums));
    }
}