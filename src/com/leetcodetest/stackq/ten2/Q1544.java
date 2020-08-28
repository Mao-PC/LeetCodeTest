package com.leetcodetest.stackq.ten2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 整理字符串
 */
public class Q1544 {
    static class Solution {
        public String makeGood(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.empty()) {
                    stack.push(c);
                } else {
                    if ((stack.peek() == c - 32 || stack.peek() == c + 32)) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            char[] chars = new char[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                chars[i] = stack.pop();
            }
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.makeGood("leEeetcode"));
        System.out.println(s.makeGood("abBAcC"));
        System.out.println(s.makeGood("s"));
    }
}
