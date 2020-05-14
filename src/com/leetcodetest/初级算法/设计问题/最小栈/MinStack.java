package com.leetcodetest.初级算法.设计问题.最小栈;

class MinStack {

    private int[] values = null;
    private int[] minIndexs = null;

    private int min;

    private int size = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        values = new int[6];
        minIndexs = new int[6];
    }

    public void push(int x) {
        if (size == values.length - 1) {
            int[] nValues = new int[values.length * 2];
            int[] nMins = new int[values.length * 2];
            System.arraycopy(this.values, 0, nValues, 0, this.values.length);
            System.arraycopy(this.minIndexs, 0, nMins, 0, this.minIndexs.length);
            this.values = nValues;
            this.minIndexs = nMins;
        }

        values[size] = x;
        if (size == 0) {
            minIndexs[0] = 0;
            min = x;
        } else {
            if (min > x) {
                minIndexs[size] = size;
                min = x;
            } else {
                minIndexs[size] = minIndexs[size - 1];
            }
        }

        size++;
    }

    public void pop() {
        size--;
        min = getMin();
    }

    public int top() {
        return this.values[size - 1];
    }

    public int getMin() {
        if (size == 0) return 0;
        return this.values[this.minIndexs[size - 1]];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class Test {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}