package com.leetcodetest.stackq.ten1;

import java.util.Stack;

/**
 * 棒球比赛
 */
public class Q682 {
    static class Solution {
        public int calPoints(String[] ops) {
            Stack<Integer> stack = new Stack<>();
            for (String op : ops) {
                if ("+".equals(op)) {
                    Integer m = stack.pop();
                    Integer n = stack.pop();
                    stack.push(n);
                    stack.push(m);
                    stack.push(m+n);
                } else if ("D".equals(op)) {
                    stack.push(2*stack.peek());
                } else if ("C".equals(op)) {
                    stack.pop();
                } else {
                    stack.push(Integer.parseInt(op));
                }
            }
            int res = 0;
            while (!stack.empty()) {
                res += stack.pop();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(solution.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
