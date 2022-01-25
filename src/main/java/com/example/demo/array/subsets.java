package com.example.demo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class subsets {

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> ls = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return list;
    }

    private void dfs(int level, int[] nums) {
        if (level == nums.length){
            list.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[level]);
        dfs(level+1,nums);
        ls.remove(ls.size());
        dfs(level+1,nums);
    }


}
