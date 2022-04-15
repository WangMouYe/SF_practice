package com.example.demo.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * https://leetcode-cn.com/problems/majority-element-ii/
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        if (n==1){
            list.add(nums[0]);
            return list;   
        }
        
        int c = n/3;
        Map<Integer,Integer> map = new HashMap<>(n);
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for (Integer i : map.keySet()) {
            if (map.get(i)>c){
                list.add(i);
            }
        }

        return list;   
    }

    public static void main(String[] args) {
        MajorityElementII mi = new MajorityElementII();
        int [] a = {1,1,1,3,3,2,2,2};
        System.out.println(mi.majorityElement(a).toString());
    }


}
