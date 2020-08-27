package com.leetcodetest.stackq.ten1;

import java.util.Stack;

/**
 * 删除最外层的括号
 */
public class Q1021 {
    static class Solution {
        public String removeOuterParentheses(String S) {

            String res = "";

            Stack<Character> stack = new Stack<>();
            char[] chars = S.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == ')') stack.pop();

                if (!stack.empty()) res += chars[i];

                if (c == '(') stack.push('(');
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses("(()())(())"));
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
    }
}
