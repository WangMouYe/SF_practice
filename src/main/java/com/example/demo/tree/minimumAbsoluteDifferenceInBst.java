package com.example.demo.tree;

import com.example.demo.base.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 走中序遍历 变种
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class minimumAbsoluteDifferenceInBst {

    int pre;
    int ans;
    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        dns(root);
        return ans;
    }

    private void dns(TreeNode root) {
        if (root == null)return;

        dns(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            ans = Math.min(ans,root.val-pre);
            pre = root.val;
        }
        dns(root.right);
    }


}
