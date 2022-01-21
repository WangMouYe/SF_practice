package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class sumOfLeftLeaves {

    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,false);
        return res;
    }

    private void dfs(TreeNode root, boolean ifLeft) {
        if (root == null)return;
        if (root.left == null && root.right == null && ifLeft){
            res += root.val;
        }
        dfs(root.left,true);
        dfs(root.right,false);
    }


}
