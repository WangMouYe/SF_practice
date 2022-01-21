package com.example.demo.tree;

import com.example.demo.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class averageOfLevelsInBinaryTree {

    List<List<Integer>> list = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        dns(root,0);
        List<Double> result = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            OptionalDouble doubleStream = list.get(i).stream().mapToDouble(Integer::doubleValue).average();
            double asDouble = doubleStream.getAsDouble();
            result.add(asDouble);
        }
        return result;
    }

    private void dns(TreeNode root, int level) {
        if (root == null)return;
        if (list.size() == level)list.add(new ArrayList<>());
        list.get(level).add(root.val);
        dns(root.left,level+1);
        dns(root.right,level+1);
    }


    public static void main(String[] args) {
//        List<List<Integer>> list = new ArrayList<>();
//        list.add()
    }








}
