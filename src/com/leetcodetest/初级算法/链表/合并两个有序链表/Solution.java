package com.leetcodetest.初级算法.链表.合并两个有序链表;

import com.leetcodetest.初级算法.链表.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node = null;
        ListNode lastNode = null;
        while (l1 != null && l2 != null) {
            ListNode cNode = null;
            if (l1.val < l2.val) {
                cNode = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cNode = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (node == null) {
                node = cNode;
                lastNode = cNode;
            } else {
                lastNode.next = cNode;
                lastNode = lastNode.next;
            }
        }

        if (l1 != null) lastNode.next = l1;
        if (l2 != null) lastNode.next = l2;

        return node;
    }
}

class Test {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getList(1, 2, 4);
        ListNode l2 = ListNode.getList(1, 3, 4);
        System.out.println(new Solution().mergeTwoLists(l1, l2));
    }
}