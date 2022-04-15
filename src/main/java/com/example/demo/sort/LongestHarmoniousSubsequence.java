package com.example.demo.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * 示例 1：
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * 示例 3：
 * 输入：nums = [1,1,1,1]
 * 输出：0
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num-1)){
                ans = Math.max(ans,map.get(num)+map.get(num-1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence lh = new LongestHarmoniousSubsequence();
//        int nums[] = {1,3,2,2,5,2,3,7};
        int nums[] = {1,2,2,1};
//        int nums[] = {1,1,1,1};
//        int nums[] = {3,2,1};
        System.out.println(lh.findLHS(nums));
    }

    /**
     * 自创解法 接化发
     * @param nums
     * @return
     */
    public int findLHS1(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            int value = nums[i];
            int countNoEq = 0;
            int countEq = 0;
            int count = 0;
            for (int j=0;j<n;j++){
                if((value+1) == nums[j] ){
                    countNoEq++;
                }
                if (value == nums[j]){
                    countEq++;
                }
                if (countNoEq!=0){
                    count = countEq + countNoEq;
                }else {
                    count = countNoEq;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }


}
