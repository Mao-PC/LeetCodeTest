package com.leetcodetest.stackq.ten2;

import com.leetcodetest.初级算法.树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 设计一个支持增量操作的栈
 */
public class Q94 {
    static class Solution {

        private Stack<TreeNode> stack = new Stack<>();

        private void pushNode(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public List<Integer> inorderTraversal(TreeNode root) {

            pushNode(root);

            List<Integer> list = new ArrayList<>();
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) {
                    pushNode(node.right);
                }
            }

            return list;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = new TreeNode(3);

        System.out.println(s.inorderTraversal(root));
    }
}
