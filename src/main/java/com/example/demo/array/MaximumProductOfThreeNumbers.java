package com.example.demo.array;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */
public class MaximumProductOfThreeNumbers {
    /**
     * 精简版
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-2]*nums[n-3]*nums[n-1]);
    }

    /**
     * 乱版
     * @param nums
     * @return
     */
    public int maximumProduct1(int[] nums) {
        int n = nums.length;
        int sum = 1;
        if (n<=3){
            for (int num : nums) {
                sum *= num;
            }
            return sum;
        }
        Arrays.sort(nums);
        if (nums[n-3]*nums[n-2]*nums[n-1] > nums[0]*nums[1]*nums[n-1]){
            sum = nums[n-1]*nums[n-2]*nums[n-3];
        }else {
            sum = nums[0]*nums[1]*nums[n-1];
        }
        return sum;
    }
    public static void main(String[] args) {
        MaximumProductOfThreeNumbers m = new MaximumProductOfThreeNumbers();
        int nums [] = {4};
//        System.out.println(Arrays.toString(nums));
        System.out.println(m.maximumProduct(nums));
    }
}
