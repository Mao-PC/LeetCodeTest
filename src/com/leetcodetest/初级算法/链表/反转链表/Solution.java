package com.leetcodetest.初级算法.链表.反转链表;

import com.leetcodetest.初级算法.链表.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return getNextNode(new ListNode(head.val), head.next);
    }

    private ListNode getNextNode(ListNode preNode, ListNode curNode) {
        ListNode nextNode = curNode.next;
        curNode.next = preNode;
        if (nextNode != null) {
            return getNextNode(curNode, nextNode);
        }
        return curNode;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list = ListNode.getList(1, 2, 3, 4, 5);
        System.out.println(list);
        System.out.println(solution.reverseList(list));
    }
}
