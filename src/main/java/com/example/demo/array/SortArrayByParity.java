package com.example.demo.array;

import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {


    public int[] sortArrayByParity(int[] nums) {
        Integer[] res = new Integer[nums.length];
        for (int i=0;i<nums.length;i++) {
            res[i] = nums[i];
        }

        Arrays.sort(res,(a,b)->Integer.compare(a%2,b%2));

        for (int i=0;i<nums.length;i++) {
            nums[i] = res[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity s= new SortArrayByParity();
        int nums [] = {3,1,2,4};
        System.out.println(Arrays.toString(s.sortArrayByParity(nums)));
    }

    /**
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity1(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        int resCount = 0;
        for (int i=0;i<n;i++){
            if(nums[i]%2==0) {
                res[resCount++] = nums[i];
            }
        }
        for (int i=0;i<n;i++){
            if (nums[i]%2==1){
                res[resCount++] = nums[i];
            }
        }
        return res;
    }


    /**
     * 空间换时间
     * @param nums
     * @return
     */
    public int[] sortArrayByParity2(int[] nums) {
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

        for (int i=0;i<jiCount;i++){
            ou[ouCount+i] = ji[i];
        }

        return ou;
    }

}
