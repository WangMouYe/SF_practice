package com.example.demo.simple;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 *
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class searchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
       int n = nums.length;
       int low = 0;
       int high = n-1;
       int ans = n;
       while (low <= high){
           int mid = low + ((high - low)>>1);
           if (target <= nums[mid]){
               ans = n;
               high = mid - 1;
           }else low = mid + 1;
       }
       return ans;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},7));
    }
}
