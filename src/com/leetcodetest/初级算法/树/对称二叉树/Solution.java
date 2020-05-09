package com.leetcodetest.初级算法.树.对称二叉树;

import com.leetcodetest.初级算法.树.TreeNode;

/**
 * 这个解法有问题, 请看python版
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(new TreeNode[]{root});
    }

    private boolean isSymmetric(TreeNode[] nodes) {
        if (nodes == null || nodes.length == 0) return true;

        int num = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) num++;
        }
        // 如果全部都是null, 说明已经是末尾了
        if (num == nodes.length) return true;

        TreeNode[] treeNodes = new TreeNode[nodes.length * 2];

        for (int i = 0; i < nodes.length / 2; i++) {
            TreeNode nodel = nodes[i];
            TreeNode noder = nodes[nodes.length - 1 - i];

            if (nodel != null && noder != null) {
                TreeNode lLeft = nodel.left;
                TreeNode lRight = nodel.right;
                TreeNode rLeft = noder.left;
                TreeNode rRight = noder.right;
                if (lLeft != null && rRight != null) {
                    if (lLeft.val != rRight.val) return false;
                }
                if (lRight != null && rLeft != null) {
                    if (lRight.val != rLeft.val) return false;
                }
                treeNodes[i * 2] = lLeft;
                treeNodes[i * 2 + 1] = lRight;
                treeNodes[treeNodes.length - (i * 2) - 1] = rRight;
                treeNodes[treeNodes.length - (i * 2) - 2] = rLeft;
            }

            if (nodel == null && noder != null || nodel != null && noder == null) return false;
        }

        boolean flag = true;

        if (nodes.length % 2 == 1) {
            TreeNode right = nodes[nodes.length / 2].right;
            TreeNode left = nodes[nodes.length / 2].left;
            if (right != null && left != null) {
                flag = left.val == right.val;
            }
            if (right != null && left == null || right == null && left != null) return false;
            if (!flag) {
                return false;
            } else {
                treeNodes[nodes.length / 2] = left;
                treeNodes[nodes.length / 2 + 1] = right;
            }
        }

        return flag && isSymmetric(treeNodes);
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSymmetric(TreeNode.getTree(9, 25, 25, null, -95, -95, null, -100, null, null, -15)));
//        System.out.println(s.isSymmetric(TreeNode.getTree(1, 2, 2, 3, 4, 4, 3)));
//        System.out.println(s.isSymmetric(TreeNode.getTree(1, 2, 2, null, 3, null, 3)));
    }
}