package com.example.demo.array;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int l = n + m;
        int [] res = new int[l];

        for (int i=0;i<n;i++){
            res[i] = nums1[i];
        }

        for (int i=0;i<m;i++){
            res[n+i] = nums2[i];
        }

        Arrays.sort(res);

        double j = 0.0;
        if(l % 2 == 1){
            j = res[((l-1)/2)];
        }else {
            j = (res[l/2-1] + res[(l/2)] + 0.0)/2;
        }
        return j;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays a = new MedianOfTwoSortedArrays();
        int [] n1 = {1,2}, n2 = {3,4};
        System.out.println(a.findMedianSortedArrays(n1,n2));
    }
}
