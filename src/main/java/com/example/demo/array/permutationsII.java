package com.example.demo.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class permutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        List<Integer> output = new ArrayList<>(n);
        for (int num : nums) {
            output.add(num);
        }
        flash(set,output,0,n);
        return new ArrayList<>(set);
    }

    private void flash(Set<List<Integer>> set, List<Integer> output, int first, int n) {
        if(first==n){
            set.add(new ArrayList<>(output));
        }
        for (int i=first;i<n;i++){
            Collections.swap(output,first,i);
            flash(set, output, first+1, n);
            Collections.swap(output,first,i);
        }
    }

    public static void main(String[] args) {
        permutationsII p = new permutationsII();
        int [] nums = {1,2,3};
        System.out.println(p.permuteUnique(nums));
    }


    /**
     * 通过lambda去重
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        List<Integer> output = new ArrayList<>(n);
        for (int num : nums) {
            output.add(num);
        }
        flash2(list,output,0,n);
        list = list.stream().distinct().collect(Collectors.toList());
        return list;
    }

    private void flash2(List<List<Integer>> list, List<Integer> output, int first, int n) {
        if(first==n){
            list.add(new ArrayList<>(output));
        }
        for (int i=first;i<n;i++){
            Collections.swap(output,first,i);
            flash2(list, output, first+1, n);
            Collections.swap(output,first,i);
        }
    }


}
