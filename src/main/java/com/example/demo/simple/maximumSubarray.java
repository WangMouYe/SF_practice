package com.example.demo.simple;

/**
 * 53. 最大子数组和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 *
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 */
public class maximumSubarray {
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i=0;i<n;i++){
            sum += nums[i];
            result = Math.max(result,sum);
            if (sum<0)sum = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int [] {-2,1,-3,4,-1,2,1,-5,4} ));
    }


    /**
     * 动态规划解法 简直无解
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int pre = 0, maxNum = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxNum = Math.max(maxNum, pre);
        }
        return maxNum;
    }

}
