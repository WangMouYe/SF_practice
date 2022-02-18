package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 前序遍历（中左右）：5 4 1 2 6 7 8
 * 中序遍历（左中右）：1 4 2 5 7 6 8
 * 后序遍历（左右中）：1 2 4 7 8 6 5
 *  详情解析：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/dai-ma-sui-xiang-lu-che-di-chi-tou-qian-xjof1/
 */
public class binaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root==null) return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }

}
