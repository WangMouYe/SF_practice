package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * 前序遍历（中左右）：5 4 1 2 6 7 8
 * 中序遍历（左中右）：1 4 2 5 7 6 8
 * 后序遍历（左右中）：1 2 4 7 8 6 5
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class binaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root==null)return;
        dfs(root.left,list);
        dfs(root.right,list);
        list.add(root.val);
    }

}
