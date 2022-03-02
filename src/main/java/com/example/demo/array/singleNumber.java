package com.example.demo.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * https://leetcode-cn.com/problems/single-number/
 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                set.remove(num);
            }
        }
        return set.iterator().next();
    }


    public static void main(String[] args) {
        int nums[] = {4,1,2,1,2};
        singleNumber s = new singleNumber();
        System.out.println(s.singleNumber(nums));
    }

    /**
     * 双循环 暴力解法
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        for (int i=0;i<nums.length;i++){
            int value = nums[i];
            int count = 0;
            for (int j=0;j<nums.length;j++){
                if (value==nums[j]) count+=1;
            }
            if (count==1)return value;
        }
        return 0;
    }

    /**
     * map大法
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1)return entry.getKey();
        }
        return 0;
    }



}
