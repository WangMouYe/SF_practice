package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 前序遍历（中左右）：5 4 1 2 6 7 8
 * 中序遍历（左中右）：1 4 2 5 7 6 8
 * 后序遍历（左右中）：1 2 4 7 8 6 5
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class binaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dns(root,list);
        return list;
    }

    private void dns(TreeNode root, List<Integer> list) {
        if (root == null)return;
        list.add(root.val);
        dns(root.left,list);
        dns(root.right,list);
    }


//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        preOrder(root,list);
//        return list;
//    }
//
//    private void preOrder(TreeNode root, List<Integer> list) {
//        if (root==null)return;
//
//        list.add(root.val);
//        preOrder(root.left,list);
//        preOrder(root.right,list);
//
//    }
}
