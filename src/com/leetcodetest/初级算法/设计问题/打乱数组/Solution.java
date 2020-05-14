package com.leetcodetest.初级算法.设计问题.打乱数组;

import java.util.Arrays;

class Solution {

    private int[] nums = null;
    
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        int[] nums1 = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < nums1.length; i++) {
            int index = (int) (Math.random()*nums1.length);
            int item = nums1[index];
            nums1[index] = nums1[i];
            nums1[i] = item;
        }

        return nums1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        Solution s = new Solution(nums);

        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
        System.out.println(Arrays.toString(s.shuffle()));
    }

}