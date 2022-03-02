package com.example.demo.tree;

import com.example.demo.base.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class validateBinarySearchTree {

    Long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root) {
        if (root == null)return true;
        boolean left = inOrder(root.left);
        if (root.val <= pre)return false;
        pre = Long.valueOf(root.val);
        boolean right = inOrder(root.right);
        return left && right;
    }


//    Long pre = Long.MIN_VALUE;
//    public boolean isValidBST(TreeNode root) {
//       if (root == null)return true;
//
//       if (!isValidBST(root.left))return false;
//
//       if (root.val <= pre)return false;
//
//       pre = Long.valueOf(root.val);
//
//       return isValidBST(root.right);
//
//    }





}
