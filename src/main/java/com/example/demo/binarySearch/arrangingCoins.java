package com.example.demo.binarySearch;

/**
 * 441. 排列硬币
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 *
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * https://leetcode-cn.com/problems/arranging-coins/
 */
public class arrangingCoins {
    public int arrangeCoins(int n) {
        long l = 1, r = n;
        while (l<r){
            long mid = l + r + 1 >>1;
            if (mid*(mid+1)/2 <= n) l = mid;
            else r = mid -1;
        }
        return (int) l;
    }

    public static void main(String[] args) {
        arrangingCoins a = new arrangingCoins();
        System.out.println(a.arrangeCoins(8));
    }
}
