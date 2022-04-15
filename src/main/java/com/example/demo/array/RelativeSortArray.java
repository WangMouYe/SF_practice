package com.example.demo.array;

import java.util.*;

/**
 *  1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 示例 1：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * 示例  2:
 * 输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * 输出：[22,28,8,6,17,44]
 *
 *  https://leetcode-cn.com/problems/relative-sort-array/
 */

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr1) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int result [] = new int[arr1.length];
        int count = 0;
        for (int i=0;i<arr2.length;i++){
            Integer countSub = map.get(arr2[i]);
            for (int j=0;j<countSub;j++){
                result[count++] = arr2[i];
            }
            map.remove(arr2[i]);
        }
        List<Integer> res = new ArrayList<>();
        if (map.size()!=0){
            for (Integer i : map.keySet()) {
                Integer iv = map.get(i);
                for (int o = 0;o<iv;o++){
                    res.add(i);
                }
            }
        }
        Collections.sort(res);
        for (int i=0;i<res.size();i++){
            result[count++] = res.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        RelativeSortArray ra = new RelativeSortArray();
        int a1[] = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int a2[] = {2,42,38,0,43,21};
        System.out.println(Arrays.toString(ra.relativeSortArray(a1,a2)));
    }


    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1) list.add(num);
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        Collections.sort(list, (x, y) -> {
            if(map.containsKey(x) || map.containsKey(y)) return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }






}
