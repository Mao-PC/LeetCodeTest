package com.leetcodetest.初级算法.链表.删除链表中的节点;

import com.leetcodetest.初级算法.链表.ListNode;

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
