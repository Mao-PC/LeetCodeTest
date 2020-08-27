package com.leetcodetest.stackq.ten1;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Qoffer03 {
    static class MyQueue {
        Stack<Integer> insertStack = new Stack<>();
        Stack<Integer> deleteStack = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            insertStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
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

        /**
         * Get the front element.
         */
        public int peek() {
            if (deleteStack.empty()) {
                if (insertStack.empty()) {
                    return -1;
                }
                while (!insertStack.empty()) {
                    deleteStack.push(insertStack.pop());
                }
                return deleteStack.peek();
            } else {
                return deleteStack.peek();
            }
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return insertStack.size() == 0 && deleteStack.size() == 0;
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.empty()); // 返回 false
    }
}
