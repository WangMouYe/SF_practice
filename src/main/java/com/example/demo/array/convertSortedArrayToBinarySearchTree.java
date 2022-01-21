package com.example.demo.array;

import com.example.demo.base.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class convertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return fs(nums,0,nums.length-1);
    }

    private TreeNode fs(int[] nums, int left, int right) {
        if (left>right)return null;
        int mid = ((left+right+1)>>1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = fs(nums,left,mid-1);
        node.right = fs(nums,mid+1,right);
        return node;
    }


}
