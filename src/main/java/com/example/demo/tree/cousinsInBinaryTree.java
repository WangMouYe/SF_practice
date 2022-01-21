package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  [[3],[9,20],[-1,12,15,7],[-1,-1,-1,-1,-1,-1]]
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class cousinsInBinaryTree {

    TreeNode parent1 = null;
    TreeNode parent2 = null;
    int level1 = 0;
    int level2 = 0;
    boolean find1 = false;
    boolean find2 = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        dns(root,null,0,x,y);
        return level1 == level2 && parent1 != parent2;
    }
    private void dns(TreeNode root, TreeNode parent, int level, int x, int y) {
        if (root == null)return;
        if (root.val == x){
            parent1 = parent;
            level1 = level;
            find1 = true;
        }
        if (root.val == y){
            parent2 = parent;
            level2 = level;
            find2 = true;
        }
        dns(root.left,root,level+1,x,y);
        dns(root.right,root,level+1,x,y);
    }

}
