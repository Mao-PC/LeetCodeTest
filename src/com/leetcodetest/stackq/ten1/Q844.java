package com.leetcodetest.stackq.ten1;

import java.util.Stack;

/**
 * 比较含退格的字符串
 */
public class Q844 {
    static class Solution {
        public boolean backspaceCompare(String S, String T) {
            Stack<Character> Sstack = new Stack<>();

            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (c == '#') {
                    if (!Sstack.empty()) Sstack.pop();
                } else {
                    Sstack.push(c);
                }
            }

            Stack<Character> Tstack = new Stack<>();

            for (int i = 0; i < T.length(); i++) {
                char c = T.charAt(i);
                if (c == '#') {
                    if (!Tstack.empty()) Tstack.pop();
                } else {
                    Tstack.push(c);
                }
            }

            if (Sstack.size() != Tstack.size()) return false;

            while (!Sstack.empty()) {
                if (Sstack.pop() != Tstack.pop()) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
