package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class binaryTreeZigzagLevelOrderTraversal {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dns(root,0);

        for (int i=1; i<=list.size();i++){
            if ((i&1) != 1) // 奇不动 偶动
                Collections.reverse(list.get(i-1));
        }
        return list;
    }

    private void dns(TreeNode root, int level) {
        if (root == null) return;
        if (list.size()==level) list.add(new ArrayList<>());
        list.get(level).add(root.val);
        dns(root.left,level+1);
        dns(root.right,level+1);
    }


//    public boolean isOdd(int a){
//        if((a&1) != 1){   //是偶数
//            return true;
//        }
//        return false;
//    }
}


