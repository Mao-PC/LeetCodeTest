package com.leetcodetest.初级算法.链表.删除链表的倒数第N个节点;

import com.leetcodetest.初级算法.链表.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode[] list = new ListNode[16];
        list[0] = head;
        ListNode next = head.next;
        int i = 1;
        while (next != null) {
            if (i == list.length) {
                ListNode[] listNodes = new ListNode[(int) (list.length * 1.5)];
                System.arraycopy(list, 0, listNodes, 0, list.length);
                list = listNodes;
            }
            list[i] = next;
            next = next.next;
            i++;
        }

        if (i - n == 0) return list[1];

        ListNode preNode = list[i - n - 1];

        ListNode nextNode = list[i - n + 1];

        if (nextNode == null) {
            nextNode = null;
        }

        preNode.next = nextNode;
        return head;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list = ListNode.getList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
        solution.removeNthFromEnd(list, 2);
        System.out.println(list);
        list = ListNode.getList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);

        System.out.println(solution.removeNthFromEnd(list, 1));
        list = ListNode.getList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
        System.out.println(solution.removeNthFromEnd(list, 17));
    }
}