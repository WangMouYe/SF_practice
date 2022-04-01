package com.example.demo.array;

import java.util.*;

/**
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * 示例 1：
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0,max = Integer.MIN_VALUE;
         for (int i=0;i<n;i++){
            if (nums[i]==1) count++;
            else {
                max = Math.max(count,max);
                count = 0;
            }
        }
        return Math.max(count,max);
    }

    public static void main(String[] args) {
        int [] nums = {1,0,1,1,0,1};
        MaxConsecutiveOnes m = new MaxConsecutiveOnes();
        System.out.println(m.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes3(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        set.add(1);
        for (int i=0;i<n;i++){
            if (set.contains(nums[i])) count++;
            else {
                max = Math.max(count,max);
                count = 0;
            }
        }
        return Math.max(count,max);
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int n = nums.length;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            if (nums[i]==1){
                count++;
                if (i==n-1)list.add(count);
            }
            else{
                list.add(count);
                count = 0;
            }
        }
        return list.parallelStream().mapToInt(Integer::intValue).max().getAsInt();
        // 也可以排序之后拿到最大值
//        Collections.sort(list);
//        return list.get(list.size()-1);

    }
}
