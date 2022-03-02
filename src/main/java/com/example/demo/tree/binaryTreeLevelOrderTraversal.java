package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class binaryTreeLevelOrderTraversal {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,0);
        return list;
    }

    private void dfs(TreeNode root, int level) {
        if (root==null)return;
        if (list.size()==level) list.add(new ArrayList<>());
        list.get(level).add(root.val);
        dfs(root.left,level);
        dfs(root.right,level);
    }


}
