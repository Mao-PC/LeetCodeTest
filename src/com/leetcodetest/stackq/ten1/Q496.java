package com.leetcodetest.stackq.ten1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素 I
 */
public class Q496 {
    static class Solution {

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> stack = new Stack<>();

            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums2) {
                while (!stack.empty() && i > stack.peek()) {
                    map.put(stack.pop(), i);
                }
                stack.push(i);
            }

            int[] res = new int[nums1.length];

            for (int i = 0; i < res.length; i++) {
                Integer v = map.get(nums1[i]);
                res[i] = v == null ? -1 : v;
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }
}
