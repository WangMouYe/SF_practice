package com.example.demo.array;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 * 示例 1:
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int pre_max = nums[0];
        int pre_min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur_max = Math.max(Math.max(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            int cur_min = Math.min(Math.min(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            res = Math.max(res, cur_max);
            pre_max = cur_max;
            pre_min = cur_min;
        }
        return res;
    }


    public static void main(String[] args) {
        MaximumProductSubarray p = new MaximumProductSubarray();
        int [] nums = {2,3,-2,4};
        System.out.println(p.maxProduct(nums));
    }

}
