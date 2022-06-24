package com.example.demo.binarySearch;

import java.util.Arrays;

/**
 * 852. 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 1, high = n - 2, ans = 0;
        while (low <= high){
            int mid = low + ((high-low)>>1);
            if (arr[mid]>arr[mid+1]){
                ans = mid;
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PeakIndexInAMountainArray p = new PeakIndexInAMountainArray();
        System.out.println(p.peakIndexInMountainArray(new int [] {0,2,1,0}));
    }

    public int peakIndexInMountainArray3(int[] arr) {
        int ans = -1;
        for (int i=1;i<arr.length;i++){
            if (arr[i]>arr[i+1]){
                ans = i;
                break;
            }
        }
        return ans;
    }


    public int peakIndexInMountainArray6(int[] arr) {
        int []c = arr.clone();
        Arrays.sort(arr);
        int n = arr.length;
        int max = arr[n-1];
        for (int i=0;i<n;i++){
            if (c[i]==max)return i;
        }
        return 0;
    }

}
