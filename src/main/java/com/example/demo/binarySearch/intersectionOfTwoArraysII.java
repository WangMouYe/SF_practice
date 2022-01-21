package com.example.demo.binarySearch;

import java.util.Arrays;

/**
 * 350. 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 */
public class intersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length, l2 = nums2.length;
        int inter []= new int [Math.min(l1,l2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1<l1 && index2<l2){
            if (nums1[index1] < nums2[index2]){
                index1++;
            }else if (nums1[index1] > nums2[index2]){
                index2++;
            }else {
                inter[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(inter,0,index);
    }

    public static void main(String[] args) {
        int [] nums1 = new int []{1,2,2,1};
        int [] nums2 = new int []{2};
        intersectionOfTwoArraysII i = new intersectionOfTwoArraysII();
        int[] intersection = i.intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }

}
