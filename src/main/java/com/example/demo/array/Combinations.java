package com.example.demo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return res;
    }

    private void dfs(int u, int n, int k) {
        if (k==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=u;i<=n-k+1;i++){
            path.add(i);
            dfs(i+1,n,k-1);
            path.remove(path.size()-1);
        }
    }



}
