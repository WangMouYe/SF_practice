package com.example.demo.sort;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * 示例 1：
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 * 输入：nums = [1,3,2,2,3,1] 6 3
 * 输出：[2,3,1,3,1,2]
 * https://leetcode-cn.com/problems/wiggle-sort-ii/
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int [] res = nums.clone();
        Arrays.sort(res);
        int a = (n-1)>>1;
        int b = n-1;
        for (int i=0;i<n-1;i+=2){
            nums[i] = res[a--];
            nums[i+1] = res[b--];
        }
        if (n%2==1){
            nums[n-1] = res[a];
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,5,1,1,6,4};
        WiggleSortII ws = new WiggleSortII();
        ws.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}

