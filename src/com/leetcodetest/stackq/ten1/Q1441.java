package com.leetcodetest.stackq.ten1;

import java.util.ArrayList;
import java.util.List;

/**
 * 用栈操作构建数组
 */
public class Q1441 {
    static class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> res = new ArrayList<>();
            int num = 1;
            for (int i = 0; i < target.length && num <= n; ) {
                int v = target[i];
                res.add("Push");
                if (v == num) {
                    i++;
                } else {
                    res.add("Pop");
                }
                num++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.buildArray(new int[]{1, 2}, 4));
        System.out.println(s.buildArray(new int[]{2, 3, 4}, 4));
    }
}
