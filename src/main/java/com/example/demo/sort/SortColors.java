package com.example.demo.sort;

import com.sun.xml.internal.ws.developer.SchemaValidation;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums==null || nums.length==1)return;
        int n = nums.length;
        int start = 0;
        int end = n-1;
        for (int i=0;i<n;i++){
            if (i>end){
                break;
            }
            if (nums[i]==0){
                int tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;
                start++;
            }else if (nums[i]==2){
                int tmp = nums[end];
                nums[end] = nums[i];
                nums[i] = tmp;
                end--;
                i--;
            }
        }
    }











    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        SortColors s = new SortColors();
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 计数排序
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int x = 0,y = 0,z = 0;
        for (int i=0;i<nums.length;i++){
            switch (nums[i]){
                case 0: x++;break;
                case 1: y++;break;
                case 2: z++;break;
            }
        }
        for (int i=0;i<nums.length;i++){
            if (i<x){
                nums[i] = 0;
            }else if (i<x+y){
                nums[i] = 1;
            }else if (i<x+y+z)
                nums[i] = 2;
        }
    }


    /**
     * 一步排序
     * @param nums
     */
    public void sortColors1(int[] nums) {
        Arrays.sort(nums);
    }


    public void sortColors2(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i=0;i<n;i++){
            if (nums[i]==0){
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ++ptr;
            }
        }

        for (int i=ptr;i<n;i++){
            if (nums[i]==1){
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ++ptr;
            }
        }

    }

}
