package com.leetcodetest.初级算法.树.二叉树的层序遍历;

import com.leetcodetest.初级算法.树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        getList(root, 0);
        return res;
    }

    private void getList(TreeNode node, int i) {
        if (node == null) return;

        if (res.size() == i) res.add(new ArrayList<>());

        res.get(i).add(node.val);

        getList(node.left, i+1);
        getList(node.right, i+1);
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().levelOrder(TreeNode.getTree(3,9,20,null,null,15,7)));
    }
}