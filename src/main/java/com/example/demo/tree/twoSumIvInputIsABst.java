package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
public class twoSumIvInputIsABst {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<list.size();i++){
            if (map.containsKey(list.get(i))){
                return true;
            }
            map.put(k-list.get(i),i);
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root==null)return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }


}
