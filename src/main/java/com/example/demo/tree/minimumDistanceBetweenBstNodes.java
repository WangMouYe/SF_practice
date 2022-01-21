package com.example.demo.tree;

import com.example.demo.base.TreeNode;

/**
 *
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *走中序遍历 变种
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class minimumDistanceBetweenBstNodes {

    int ans;
    int pre;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dns(root);
        return ans;
    }

    private void dns(TreeNode root) {
        if (root == null)return;
        dns(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            ans = Math.min(ans,root.val - pre);
            pre = root.val;
        }
        dns(root.right);
    }


}
