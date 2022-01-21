package com.example.demo.tree;

import com.example.demo.base.Node;

/**
 *  559. N 叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class maximumDepthOfNAryTree {
    public int maxDepth(Node root) {
        if (root == null)return 0;
        else {
            int pre = 0;
            for (int i=0; i<root.children.size(); i++){
                pre = Math.max(maxDepth(root.children.get(i)),pre);
            }
            return pre+1;
        }
    }
}
