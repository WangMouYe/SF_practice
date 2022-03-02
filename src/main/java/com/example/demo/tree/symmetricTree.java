package com.example.demo.tree;

import com.example.demo.base.TreeNode;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class symmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root==null)return true;
        return cmp(root.left,root.right);
    }

    private boolean cmp(TreeNode n1, TreeNode n2) {
        if (n1==null && n2==null)return true;
        if (n1==null || n2==null || n1!=n2)return false;
        return cmp(n1.left,n2.right) && cmp(n1.right,n2.left);
    }

}
