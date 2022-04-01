package com.example.demo.array;

import java.util.Arrays;

/**
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * 你可以返回 任何满足上述条件的数组作为答案 。
 * 示例 1：
 * 输入：nums = [4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * 示例 2：
 * 输入：nums = [2,3]
 * 输出：[2,3]
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int [] ji = new int[n];
        int jiCount = 0;

        int [] ou = new int[n];
        int ouCount = 0;

        for (int i=0;i<n;i++){
            if (nums[i]%2==1){
                ji[jiCount] = nums[i];
                jiCount++;
            }else {
                ou[ouCount] = nums[i];
                ouCount++;
            }
        }

        int [] res = new int[n];
        int oIndex = 0, jIndex = 0;
        for (int i=0;i<n;i++){
            if (i%2==0) res[i] = ou[oIndex++];
            if (i%2==1) res[i] = ji[jIndex++];
        }
        return res;
    }
    public static void main(String[] args) {
        SortArrayByParityII s= new SortArrayByParityII();
        int nums [] = {4,2,5,7};
        System.out.println(Arrays.toString(s.sortArrayByParityII(nums)));
    }
}
