package com.example.demo.binarySearch;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * https://leetcode-cn.com/problems/binary-search/
 */
public class binarySearch {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        while (low <= high){
            int mid = low + ((high-low)>>1);
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }


    public int searchBinary(int [] nums,int target){
        return searchBinaryInternally(nums,0,nums.length-1,target);
    }

    private int searchBinaryInternally(int[] nums, int low, int high, int target) {
        if (low > high)return -1;
        int mid = low + ((high-low)>>1);
        if (nums[mid] == target)return mid;
        else if (nums[mid] < target) return searchBinaryInternally(nums,mid+1,high,target);
        else return searchBinaryInternally(nums,low,mid-1,target);
    }


    public static void main(String[] args) {
        binarySearch b = new binarySearch();
        int search = b.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(search);
    }


}
