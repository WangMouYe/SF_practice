package com.example.demo.array;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j=0;j<nums.length;j++){
            if (nums[j]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int [] nums = {0,0,1};
        moveZeroes m = new moveZeroes();
        m.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 把非0的往前挪，挪完之后，后面的就都是0了，然后在用0覆盖后面的。
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (nums==null || nums.length==0)return;
        int index = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length){
            nums[index++] = 0;
        }
    }


    public void moveZeroes21(int[] nums) {
        int n =  nums.length;
        if (n<=1) return;
        for (int i=0;i<n;i++){
            boolean flag = false;
            for (int j=0;j<n-i-1;j++){
                if (nums[j]==0){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag)break;
        }
        return;
    }


    public void moveZeroes31(int[] nums) {
        int n =  nums.length;
        if (n<=1) return;
        int lastExchange = 0;
        int sortBorder = n - 1;
        for (int i=0;i<n;i++){
            boolean flag = false;
            for (int j=0;j<sortBorder;j++){
                if (nums[j]==0){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = true;
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag)break;
        }
        return;
    }
}
