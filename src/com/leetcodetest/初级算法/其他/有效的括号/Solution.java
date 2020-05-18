package com.leetcodetest.初级算法.其他.有效的括号;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                Character peek = stack.peek();
                if (peek == '(' && c == ')' || peek == '[' && c == ']' || peek == '{' && c == '}') {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("){"));
    }
}