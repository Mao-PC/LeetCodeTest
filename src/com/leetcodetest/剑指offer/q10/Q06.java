package com.leetcodetest.剑指offer.q10;

import com.leetcodetest.初级算法.链表.ListNode;

import java.util.Arrays;
import java.util.Stack;

public class Q06 {
    static class Solution {
        public int[] reversePrint(ListNode head) {
            int[] asc = new int[10000];
            int size = 0;

            while (head != null) {
                asc[size] = head.val;
                size++;
                head = head.next;
            }

            int[] desc = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                desc[size - i - 1] = asc[i];
            }
            return desc;
        }

        /**
         * 官方结题, 使用stack
         *
         * @param head
         * @return
         */
        public int[] reversePrint1(ListNode head) {
            Stack<Integer> stack = new Stack<>();

            int size = 0;
            while (head != null) {
                stack.push(head.val);
                head = head.next;
                size++;
            }

            int[] res = new int[size];
            int index = 0;
            while (stack.size() != 0 && stack.peek() != null) {
                res[index] = stack.pop();
                index++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        ListNode list = ListNode.getList(1, 2, 3, 4);
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.reversePrint1(list)));
    }
}
