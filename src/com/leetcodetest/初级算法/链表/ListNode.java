package com.leetcodetest.初级算法.链表;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {

        String str = this.val + "";

        ListNode next = this.next;

        while (next != null) {
            str += ", " + next.val;
            next = next.next;
        }

        return str;
    }

    public static ListNode getList(int... values) {
        if (values == null || values.length == 0) return null;
        ListNode node = new ListNode(values[0]);
        ListNode node1 = node;
        for (int i = 1; i < values.length; i++) {
            ListNode cNode = new ListNode(values[i]);
            node1.next = cNode;
            node1 = node1.next;
        }
        return node;
    }
}