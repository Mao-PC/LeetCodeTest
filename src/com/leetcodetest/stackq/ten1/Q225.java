package com.leetcodetest.stackq.ten1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class Q225 {
    static class MyStack {

        Queue<Integer> queue = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int i = queue.size();
            while (i != 1) {
                i--;
                queue.add(queue.poll());
            }

            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            int i = queue.size();
            while (i != 1) {
                i--;
                queue.add(queue.poll());
            }

            Integer top = queue.poll();

            queue.add(top);

            return top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }
}
