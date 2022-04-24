package com.example.demo.array;

import java.util.Map;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n<1)return 0;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int sum = 0;
            for (int j=i;j<n;j++){
                sum += nums[j];
                if (sum>=target){
                    min = Math.min(min,j-i+1);
                    break;
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum s = new MinimumSizeSubarraySum();
        System.out.println(s.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }

//    private int label(int i,int target, int[] nums) {
//        int l
//        return 0;
//    }

}
