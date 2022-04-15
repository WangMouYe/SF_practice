package com.example.demo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * https://leetcode-cn.com/problems/single-number-iii/
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int [] res = new int[2];
        int count = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i).equals(1)){
                res[count++] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumberIII s = new SingleNumberIII();
        int [] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(s.singleNumber(nums)));
    }


}
