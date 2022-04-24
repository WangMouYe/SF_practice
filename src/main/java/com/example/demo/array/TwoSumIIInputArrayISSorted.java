package com.example.demo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputArrayISSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while (l<r){
            int num = numbers[l]+numbers[r];
            if (num == target){
                return new int[]{l+1,r+1};
            }else if (num > target){
                r--;
            }else {
                l++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSumIIInputArrayISSorted t = new TwoSumIIInputArrayISSorted();
        System.out.println(Arrays.toString(t.twoSum(new int[] {2,7,11,15},9)));
    }

    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            if (map.containsKey(target - numbers[i])){
                return new int[]{map.get(target - numbers[i])+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return new int[2];
    }

}
