package com.leetcodetest.剑指offer.q10;

import java.util.HashSet;
import java.util.Set;


public class Q03 {
    static class Solution {
        public int findRepeatNumber(int[] nums) {
            boolean[] flags = new boolean[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (!flags[num]) {
                    flags[num] = true;
                } else {
                    return num;
                }
            }
            return -1;
        }

        /**
         * 官方答案, 使用set
         *
         * @param nums
         * @return
         */
        public int findRepeatNumber1(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.add(num)) {
                    return num;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findRepeatNumber1(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}