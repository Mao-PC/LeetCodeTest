package com.leetcodetest.stackq.ten2;

import com.leetcodetest.初级算法.树.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树迭代器
 */
public class Q173 {
    static class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            push2stack(root);
        }

        private void push2stack(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) push2stack(node.right);
            return node.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.empty();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        TreeNode right = new TreeNode(15);
        root.right = right;
        right.left = new TreeNode(9);
        right.right = new TreeNode(20);
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
