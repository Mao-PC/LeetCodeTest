package com.leetcodetest.初级算法.链表.环形链表;

import com.leetcodetest.初级算法.链表.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return false;
        // 快指针
        ListNode quickNode = head.next.next;
        // 慢指针
        ListNode slowNode = head;
        while (quickNode != null) {
            if (quickNode == slowNode) {
                return true;
            }
            quickNode = quickNode.next;
            if (quickNode == null) return false;
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode list = ListNode.getList(3, 2, 0, -4);
        System.out.println(s.hasCycle(list));
        list.next.next.next.next = list.next;
        System.out.println(s.hasCycle(list));
    }
}