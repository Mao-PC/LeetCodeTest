package com.leetcodetest.stackq.ten2;

import java.util.Stack;

/**
 * 使括号有效的最少添加
 */
public class Q921 {
    static class Solution {
        public int minAddToMakeValid(String S) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (!stack.empty() && c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.size();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minAddToMakeValid("())"));
        System.out.println(s.minAddToMakeValid("((("));
        System.out.println(s.minAddToMakeValid("()"));
        System.out.println(s.minAddToMakeValid("()))(("));
    }
}
