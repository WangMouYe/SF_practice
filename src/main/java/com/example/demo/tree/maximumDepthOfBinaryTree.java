package com.example.demo.tree;

import com.example.demo.base.TreeNode;
import com.sun.xml.internal.messaging.saaj.soap.GifDataContentHandler;

import java.util.ArrayList;
import java.util.List;

public class maximumDepthOfBinaryTree {

    List<List<Integer>> list = new ArrayList<>();

    /**
     * 层序遍历公式套用
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return list.size();
    }

    private void dfs(TreeNode root, int level) {
        if (root==null)return;
        if (list.size()==level)list.add(new ArrayList<>());
        list.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }

    /**
     * 递归左子树与右子树
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null)return 0;
        else return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }


}
