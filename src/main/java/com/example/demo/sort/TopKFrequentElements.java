package com.example.demo.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements d = new TopKFrequentElements();
//        int [] nums = {1,1,1,2,2,3};
        int [] nums = {1};
        System.out.println(Arrays.toString(d.topKFrequent(nums,1)));;
    }


    /**
     * 使用map 记录每个元素的出现个数
     * 之后双循环 得到每次的最大值 并移除元素
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        int [] res = new int[k];
        for (int i=0;i<k;i++){
            int max = Integer.MIN_VALUE;
            int value = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue()>max){
                    max = entry.getValue();
                    value = entry.getKey();
                }
            }
            res[i] = value;
            map.remove(value);
        }
        return res;
    }

}
