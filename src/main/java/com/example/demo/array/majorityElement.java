package com.example.demo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * https://leetcode-cn.com/problems/majority-element/
 */
public class majorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        int n = nums.length/2;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()>n)return entry.getKey();
        }
        return 0;
    }

    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        majorityElement m = new majorityElement();
        System.out.println(m.majorityElement(nums));
    }
}
