package com.example.demo.binarySearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class findFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int [] index = new int[]{-1,-1};
        int n = nums.length;
        if (n<1)return index;
        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = low + ((high-low)>>1);
            mid:
            if (nums[mid]==target){
                if (index[0]==-1){
                    index[0] = mid;
                    index[1] = mid;
                    nums[mid] = Integer.MAX_VALUE;
                    if (n==1)return index;
                }else if (index[0]!=-1){
                    index[1] = mid;
                    Arrays.sort(index);
                    return index;
                }
            }else if (nums[mid] < target)low = mid +1;
            else high = mid-1;
        }
        Arrays.sort(index);
        return index;
    }

    public static void main(String[] args) {
        findFirstAndLastPositionOfElementInSortedArray f = new findFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(f.searchRange(new int[]{5,7,7,8,8,10},8 )));
    }

    /**
     * 传统循环解法 性能颇低
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
        int [] index = new int[]{-1,-1};
        if (nums.length<1)return index;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==target){
                if (index[0]==-1){
                    index[0]=i;
                    index[1]=i;
                }
                else index[1] = i;
            }
        }
        return index;
    }

}
