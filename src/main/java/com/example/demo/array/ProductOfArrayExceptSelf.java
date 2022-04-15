package com.example.demo.array;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, l = 1, r = 1;
        int[] res = new int[n];
        for (int i=0;i<n;i++){
            res[i] = 1;
        }
        for (int i=0;i<n;i++){
            res[i] *= l;
            l *= nums[i];
            res[n-1-i] *= r;
            r *= nums[n-1-i];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf self = new ProductOfArrayExceptSelf();
//        int nums [] = {-1,1,0,-3,3};
        int nums [] = {1,2,3,4};
        System.out.println(Arrays.toString(self.productExceptSelf(nums)));
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1;i<n;i++){
            res[i] = nums[i-1] * res[i-1];
        }
        int r = 1;
        for (int i = n-1; i>=0; i--){
            res[i] = res[i] * r;
            r *= nums[i];
        }
        return res;
    }



}
