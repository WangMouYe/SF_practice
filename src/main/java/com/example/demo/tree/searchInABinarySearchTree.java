package com.example.demo.tree;

import com.example.demo.base.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 *
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 *
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class searchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)return null;
        if (root.val == val)return root;
        return searchBST(val<root.val ? root.left : root.right,val);
    }

}
