package com.example.demo.array;

import java.util.*;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * 示例 1：
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * 示例 2：
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 * https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/
 */
public class NRepeatedElementINSize2nArray {
    public int repeatedNTimes(int[] nums) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
            if (map.get(num)>1) count = num;
        }
        return count;
    }

    public static void main(String[] args) {
        NRepeatedElementINSize2nArray s = new NRepeatedElementINSize2nArray();
        int nums[] = {2,1,2,5,3,2};
        System.out.println(s.repeatedNTimes(nums));
    }

    /**
     * set判重
     * @param nums
     * @return
     */
    public int repeatedNTimes1(int[] nums) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                count=num;
                break;
            }
        }
        return count;
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public int repeatedNTimes2(int[] nums) {
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1])return nums[i];
        }
        return 0;
    }


}

