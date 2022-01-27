package com.example.demo.array;

import java.util.*;

/**
 * 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class containsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
            if (nums[i] == nums[i+1])return true;
        }
        return false;
    }


    /**
     * 最废柴的解法
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        int length = nums.length;
        for (int i=0;i<length;i++){
            int value = nums[i];
            for (int j=i+1;j<length;j++){
                if (value == nums[j])return true;
            }
        }
        return false;
    }

    /**
     * HashMap解法
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<length;i++){
            if (map.containsKey(nums[i]))return true;
            else
                map.put(nums[i],i);
        }
        return false;
    }

    /**
     * HashSet解法
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))return true;
        }
        return false;
    }



    public static void main(String[] args) {
        int p[] = new int[]{1,2,3,4};
        Arrays.sort(p);
        containsDuplicate c = new containsDuplicate();
        System.out.println(c.containsDuplicate(p));
    }


}
