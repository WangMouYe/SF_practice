package com.example.demo.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class FirstMissingOPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(n);
        for (int num : nums) {
            set.add(num);
        }

        for (int i=1;i<=n;i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,0};
        FirstMissingOPositive p = new FirstMissingOPositive();
        System.out.println(p.firstMissingPositive(nums));
    }
}
