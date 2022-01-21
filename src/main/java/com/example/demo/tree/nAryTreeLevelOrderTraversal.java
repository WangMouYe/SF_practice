package com.example.demo.tree;

import com.example.demo.base.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 *https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class nAryTreeLevelOrderTraversal {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        dns(root,0);
        return list;
    }

    private void dns(Node root, int level) {
        if (root == null)return;
        if (list.size() == level)list.add(new ArrayList<>());
        list.get(level).add(root.val);
        if (root.children != null){
            for (int i=0;i<root.children.size();i++){
                dns(root.children.get(i),level+1);
            }
        }
    }

}
