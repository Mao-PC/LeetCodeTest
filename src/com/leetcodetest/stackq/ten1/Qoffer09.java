package com.leetcodetest.stackq.ten1;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Qoffer09 {
    static class CQueue {
        Stack<Integer> insertStack = new Stack<>();
        Stack<Integer> deleteStack = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            insertStack.push(value);
        }

        public int deleteHead() {
            if (deleteStack.empty()) {
                if (insertStack.empty()) {
                    return -1;
                }
                while (!insertStack.empty()) {
                    deleteStack.push(insertStack.pop());
                }
                return deleteStack.pop();
            } else {
                return deleteStack.pop();
            }
        }
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
