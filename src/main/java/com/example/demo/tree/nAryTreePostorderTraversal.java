package com.example.demo.tree;

import com.example.demo.base.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * 进阶：
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class nAryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dns(root,list);
        return list;
    }

    private void dns(Node root, List<Integer> list) {
        if (root == null)return;

        if (root.children != null){
            for (int i=0;i<root.children.size();i++){
                dns(root.children.get(i),list);
            }
        }
        list.add(root.val);

    }

}
