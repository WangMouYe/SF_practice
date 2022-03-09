package com.example.demo.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class findAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(n);
        for (int i=0;i<n;i++){
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(n);
        for (int i=1;i<n+1;i++) {
            if (!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        findAllNumbersDisappearedInAnArray f = new findAllNumbersDisappearedInAnArray();
        System.out.println(f.findDisappearedNumbers(nums));
    }

}
