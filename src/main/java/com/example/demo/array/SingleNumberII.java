package com.example.demo.array;

import java.util.*;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * https://leetcode-cn.com/problems/single-number-ii/
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i).equals(1)){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SingleNumberII s = new SingleNumberII();
        int nums [] = {0,1,0,1,0,1,99};
        System.out.println(s.singleNumber(nums));
    }


}
