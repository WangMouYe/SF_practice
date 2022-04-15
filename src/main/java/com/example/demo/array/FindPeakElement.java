package com.example.demo.array;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * https://leetcode-cn.com/problems/find-peak-element/
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i=1;i<n;i++){
            if (nums[i]>nums[index]){
               index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        int nums [] = {1,2,1,3,5,6,4};
//        int nums [] = {1,2,3};
        System.out.println(f.findPeakElement(nums));
    }


    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        if (n==1)return 0;
        if (n==2)return nums[0]>nums[1]?0:1;
        int index = 0;
        for (int i=1;i<n;i++){
            if (i==(n-1)){
                if (nums[i]>nums[i-1]){
                    return i;
                }
            }else {
                if (nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }


    public int findPeakElement3(int[] nums) {
        int n = nums.length;
        if (n==1)return 0;
        if (n==2)return nums[0]>nums[1]?0:1;
        int index = 0;
        for (int i=1;i<n;i++){
            if (nums[i]>nums[i-1]){
                if (i!=(n-1)){
                    if (nums[i]>nums[i+1]){
                        index = i;
                        break;
                    }
                }else return i;
            }
        }
        return index;
    }

}
