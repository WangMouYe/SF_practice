package com.example.demo.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 247. 中心对称数 II
 * 给定一个整数 n ，返回所有长度为 n 的 中心对称数 。你可以以 任何顺序 返回答案。
 * 中心对称数 是一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * 示例 1:
 * 输入：n = 2
 * 输出：["11","69","88","96"]
 * 示例 2:
 * 输入：n = 1
 * 输出：["0","1","8"]
 * 提示：
 * 1 <= n <= 14
 */
public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        if (n<=0)return new ArrayList<>();
        if (n==1)return Arrays.asList("0","1","8");
        if (n==2)return Arrays.asList("11","69","88","96");
        List<String>[] arr = new List[n+1];
        arr[1] = Arrays.asList("0","1","8");
        arr[2] = Arrays.asList("00","11","69","88","96");
        for (int i=3;i<n;i++){
            List<String> tmpList = new ArrayList<>();
            for (String s : arr[i - 2]) {
                if (i!=n){
                    tmpList.add("0"+s+"0");
                }
                tmpList.add("1"+s+"1");
                tmpList.add("6"+s+"9");
                tmpList.add("8"+s+"8");
                tmpList.add("9"+s+"6");
            }
            arr[i] = tmpList;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII strobogrammaticNumberII = new StrobogrammaticNumberII();
        System.out.println(strobogrammaticNumberII.findStrobogrammatic(2));
    }

}
