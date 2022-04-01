package com.example.demo.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> subList = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(subList,candidates,target,0,0);
        return list;
    }

    private void dfs(List<Integer> subList, int[] candidates, int target, int sum, int begin) {
        if (target==sum){
            list.add(new ArrayList<>(subList));
        }
        for (int i=begin;i<candidates.length;i++){
            if (i>begin && candidates[i]==candidates[i-1]) continue;
            int rs = candidates[i] + sum;
            if (rs <= target){
                subList.add(candidates[i]);
                dfs(subList,candidates,target,rs,i+1);
                subList.remove(subList.size()-1);
            }else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();
        int []a = {10,1,2,7,6,1,5};
        System.out.println(c.combinationSum2(a,8));
    }
}
