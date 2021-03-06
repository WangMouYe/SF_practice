package com.example.demo.tree;

import com.example.demo.base.TreeNode;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * https://leetcode-cn.com/problems/same-tree/
 */
public class sameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dns(p,q);
    }

    private boolean dns(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p==null || q==null)return false;
        if (p.val != q.val)return false;
        return dns(p.left , q.left) && dns(p.right , q.right);
    }
}
