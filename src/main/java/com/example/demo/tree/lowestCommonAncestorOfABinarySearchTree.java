package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 */
public class lowestCommonAncestorOfABinarySearchTree {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (1==1){
            if (p.val < node.val && q.val < node.val){
                node = node.left;
            }else if (p.val > node.val && q.val > node.val){
                node = node.right;
            }else break;
        }
        return node;
    }

}
