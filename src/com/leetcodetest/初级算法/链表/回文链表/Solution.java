package com.leetcodetest.初级算法.链表.回文链表;

import com.leetcodetest.初级算法.链表.ListNode;

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int[] arr = new int[16];
        int size = 0;
        while (head != null) {
            if (size == arr.length) {
                int[] arr1 = new int[arr.length * 2];
                System.arraycopy(arr, 0, arr1, 0, arr.length);
                arr = arr1;
            }
            arr[size] = head.val;
            size++;
            head = head.next;
        }

        for (int i = 0; i < size / 2; i++) {
            if (arr[i] != arr[size - i -1]) return false;
        }

        return true;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(ListNode.getList(1, 2)));
        System.out.println(solution.isPalindrome(ListNode.getList(1)));
        System.out.println(solution.isPalindrome(ListNode.getList(1, 2, 1)));
        System.out.println(solution.isPalindrome(ListNode.getList(1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1)));
    }
}