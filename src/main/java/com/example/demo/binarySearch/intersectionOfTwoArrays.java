package com.example.demo.binarySearch;

import java.util.*;
import java.util.stream.Collectors;

/**
 *349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
public class intersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length, l2 = nums2.length;
        int [] inter = new int [Math.min(l1,l2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < l1 && index2 < l2){
            if (nums1[index1] < nums2[index2]){
                index1++;
            }else if (nums1[index1] > nums2[index2]){
                index2++;
            }else {
                if (index==0 || nums1[index1] != inter[index-1]){
                    inter[index++] = nums1[index1];
                }
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(inter,0,index);
    }

    public static void main(String[] args) {
        int [] nums1 = new int []{1,2,2,1};
        int [] nums2 = new int []{2,2};
        intersectionOfTwoArrays i = new intersectionOfTwoArrays();
        int[] intersection = i.intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }

    /**
     * 原始级 冒泡解法 一法通则万法皆通
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        int [] res = new int [nums1.length];
        int ans = 0;
        for (int i=0;i<nums1.length;i++){
            int a = nums1[i];
            sec:
            for (int j=0;j<nums2.length;j++){
                int b = nums2[j];
                if (a==b){
                    if (ans > 0){
                        for (int z=0;z<ans;z++){
                            if (a==res[z])break sec;
                        }
                    }
                    res[ans] = a;
                    ans++;
                    break sec;
                }
            }
        }
        int [] tr;
        if (ans>0){
            tr = new int [ans];
            for (int i=0;i<ans;i++){
                tr[i] = res[i];
            }
        }else return new int []{};
        return tr;
    }

    /**
     * java集合 HashSet上场 效率也不咋地
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int n1: nums1){
            list.add(n1);
        }
        for (int n2: nums2){
            s2.add(n2);
        }
        list.retainAll(s2);
        s1.addAll(list);
        return s1.stream().mapToInt(i->i).toArray();
    }

    /**
     * stream表达式 依旧不是最佳解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }
}
