package com.example.demo.array;

import java.beans.IntrospectionException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 540. 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * 示例 1:
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0,high = nums.length-1;
        while (low < high){
            int mid = ((high-low)>>1) + low;
            if (nums[mid]==nums[mid^1]){
                low = mid +1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }


    public static void main(String[] args) {
        SingleElementInASortedArray s = new SingleElementInASortedArray();
//        int [] nums = {1,1,2,3,3,4,4,8,8};
//        int [] nums = {1,1,2};
//        int [] nums = {1,2,2,3,3};
        int [] nums = {1};
        System.out.println(s.singleNonDuplicate(nums));
    }

    /**
     * 滑动窗口
     * @param nums
     * @return
     */
    public int singleNonDuplicate3(int[] nums) {
        int n = nums.length;
        for (int i=0;i<n-1;i+=2){
            if (nums[i]!=nums[i+1])
                return nums[i];
        }
        return nums[n-1];
    }

    /**
     * 连着好几道的map 好舒服
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int res = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i).equals(1)){
                res = i;
            }
        }
        return res;
    }

}
