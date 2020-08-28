package com.leetcodetest.stackq.ten1;

import java.util.ArrayList;
import java.util.List;

/**
 * 栈的最小值
 */
public class Qview03 {
    static class MinStack {

        List<Integer> list = new ArrayList<>();
        List<Integer> min = new ArrayList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public void push(int x) {
            list.add(x);
            if (min.size() == 0) {
                min.add(x);
            } else {
                Integer preMin = min.get(min.size() - 1);
                if (preMin > x) {
                    min.add(x);
                } else {
                    min.add(preMin);
                }
            }
        }

        public void pop() {
            int i = list.size() - 1;
            list.remove(i);
            min.remove(i);
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int getMin() {
            return min.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);
        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());
        minStack.push(-20);
        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(10);
        minStack.push(-7);
        System.out.println(minStack.getMin());
        minStack.push(-7);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
    }
}
