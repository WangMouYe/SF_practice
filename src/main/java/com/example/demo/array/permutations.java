package com.example.demo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * https://leetcode-cn.com/problems/permutations/
 */
public class permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        flash(list,output,0,n);
        return list;
    }

    private void flash(List<List<Integer>> list, List<Integer> output, int first, int n) {
        if (first==n){
            list.add(new ArrayList<Integer>(output));
        }
        for (int i=first;i<n;i++){
            Collections.swap(output,first,i);
            flash(list,output,first+1,n);
            Collections.swap(output,first,i);
        }
    }

    public static void main(String[] args) {
        permutations p = new permutations();
        int nums[] = {1,2,3};
        System.out.println(p.permute(nums).toString());
    }


}
