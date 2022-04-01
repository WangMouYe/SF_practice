package com.example.demo.array;

import java.util.Arrays;

/**
 * 496. 下一个更大元素 I
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * 示例 1：
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 * https://leetcode-cn.com/problems/next-greater-element-i/v
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int [] res = new int [n];
        for (int i=0;i<n;i++){
            int value = nums1[i];
            for (int j=0;j<nums2.length;j++){
                if (value == nums2[j]){
                    if (j!=nums2.length-1){
                        for (int x = j; x<nums2.length; x++){
                            if (nums2[x]>value) {
                                res[i] = nums2[x];break;
                            }
                        }
                    }
                }
            }
        }
        for (int i=0;i<n;i++) {
            if (res[i]==0)res[i] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementI x = new NextGreaterElementI();
        int nums1 [] = {2,4};
        int nums2 [] = {1,2,3,4};
        System.out.println(Arrays.toString(x.nextGreaterElement(nums1,nums2)));
    }

    /**
     * 三层循环法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int [] res = new int [n];
        for (int i=0;i<n;i++){
            int value = nums1[i];
            for (int j=0;j<nums2.length;j++){
                if (value == nums2[j]){
                    if (j!=nums2.length-1){
                        for (int x = j; x<nums2.length; x++){
                            if (nums2[x]>value) {
                                res[i] = nums2[x];break;
                            }
                        }
                    }
                }
            }
        }
        for (int i=0;i<n;i++) {
            if (res[i]==0)res[i] = -1;
        }
        return res;
    }
}
