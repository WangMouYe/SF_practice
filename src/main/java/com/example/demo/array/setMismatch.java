package com.example.demo.array;

import java.util.*;

/**
 * 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * 示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * https://leetcode-cn.com/problems/set-mismatch/
 */
public class setMismatch {
    /**
     * 新版本map的方法 使用getOrDefault方法 但是与老版本耗时性能近乎相同
     * 不过可以减少编写的复杂程度 毕竟他只需两次循环 不需要循环map
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int [] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int i=1;i<=n;i++){
            int count = map.getOrDefault(i,0);
            if (count==2) res[0] = i;
            else if (count==0) res[1] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        setMismatch s = new setMismatch();
        System.out.println(Arrays.toString(s.findErrorNums(new int []{1,1})));
    }

    /**
     * 老版map解法 利用HashMap key不能重复的原理 将得到的结果依次注入
     * @param nums
     * @return
     */
    public int[] findErrorNums1(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i=1;i<=n;i++){
            map.put(i,0);
        }
        for (int num : nums) {
            if (map.containsKey(num))map.put(num,map.get(num)+1);
        }
        int [] res = new int[2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()>=2){
                res[0] = entry.getKey();
            }
            if (entry.getValue()==0){
                res[1] = entry.getKey();
            }
        }
        return res;
    }

}
