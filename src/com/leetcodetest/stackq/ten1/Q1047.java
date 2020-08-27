package com.leetcodetest.stackq.ten1;

import java.util.Stack;

/**
 * 删除字符串中的所有相邻重复项
 */
public class Q1047 {
    static class Solution {
        public String removeDuplicates(String S) {
            if (S.length() == 1) return S;

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                char aChar = S.charAt(i);
                if (stack.empty()) {
                    stack.push(aChar);
                } else {
                    Character c = stack.peek();
                    if (c.equals(aChar)) {
                        stack.pop();
                    } else {
                        stack.push(aChar);
                    }
                }
            }

            char[] chars = new char[stack.size()];

            int index = stack.size() - 1;
            while (!stack.empty()) {
                Character c = stack.pop();
                chars[index--] = c;
            }
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        String s = new Solution().removeDuplicates("abbaca");
        System.out.println(s);
    }
}
