package com.example.demo.array;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int maxIndex = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[maxIndex]>nums[i]){
                //找出大于nums[i] 且最小的数的下标
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]>nums[i] && nums[j]<nums[maxIndex]){
                        maxIndex = j;
                    }
                }
                //交换
                int t = nums[maxIndex];
                nums[maxIndex] = nums[i];
                nums[i] = t;
                //i后面的值 从小到达排列保证最小
                Arrays.sort(nums,i+1,nums.length);
                return;
            }
            //更新最大值
            if(nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }

        for(int i=0,j=nums.length-1;i<j;i++,j--){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j]=t;
        }
    }
}
