package com.example.demo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * https://leetcode-cn.com/problems/minimum-absolute-difference/
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length; // 4 2 1 3
        // 排序
        Arrays.sort(arr);   // 1 2 3 4
        // 得到最小差
        int min = Integer.MAX_VALUE;
        for (int i=1;i<n;i++){
            min = Math.min(arr[i] -arr[i-1],min);
        }
        // 再次循环 如果arr[i] -arr[i-1] == min 就直接入列
        for (int i=1;i<n;i++){
            if (arr[i]-arr[i-1] == min){
                List<Integer> sub = new ArrayList<>(2);
                sub.add(arr[i-1]);
                sub.add(arr[i]);
                list.add(sub);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        MinimumAbsoluteDifference d = new MinimumAbsoluteDifference();
//        int [] arr = {4,2,1,3};
//        int [] arr = {1,3,6,10,15};
        int [] arr = {3,8,-10,23,19,-4,-14,27};
        System.out.println(d.minimumAbsDifference(arr).toString());
    }
}
