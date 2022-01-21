package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 107. 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层序遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class binaryTreeLevelOrderTraversalIi {

    /**
     * 方法一： 循环反转
     */
//    List<List<Integer>> list = new ArrayList<>();
//    List<List<Integer>> result = new ArrayList<>();
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        dns(root,0);
//        if (list!=null && list.size()!=0){
//            for (int i=list.size()-1; i>=0; i--){
//                result.add(list.get(i));
//            }
//        }
//        return result;
//    }
//    private void dns(TreeNode root, int level) {
//        if (root == null)return;
//        if (list.size()==level) list.add(new ArrayList<>());
//        list.get(level).add(root.val);
//        dns(root.left,level+1);
//        dns(root.right,level+1);
//    }

    /**
     * 方法二：逆向递归
     */
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dns(root,0);
        return list;
    }

    private void dns(TreeNode root, int level) {
        if (root == null)return;
        if (list.size() == level)list.add(new ArrayList<>());
        list.get(list.size()-level-1).add(root.val);
        dns(root.left,level+1);
        dns(root.right,level+1);
    }


}
