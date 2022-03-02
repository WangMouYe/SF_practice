package com.example.demo.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 */
public class containsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,1,2,3};
        containsDuplicateII c = new containsDuplicateII();
        System.out.println(c.containsNearbyDuplicate(nums,2));
    }

    /**
     * map 解法
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])){
                Integer j = map.get(nums[i]);
                if (Math.abs(i-j)<=k)return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }

}
