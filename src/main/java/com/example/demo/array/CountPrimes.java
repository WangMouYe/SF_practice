package com.example.demo.array;

import java.util.Arrays;

/**
 * 204. 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * https://leetcode-cn.com/problems/count-primes/
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n<2)return 0;
        int count = 0;
        for (int i=2;i<n;i++){
            count += isZhi(i)?1:0;
        }
        return count;
    }

    private boolean isZhi(int i) {
        for(int j=2;j*j<=i;j++) {
            if(i % j == 0) {
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        System.out.println(c.countPrimes(10));
    }

    public int countPrimes3(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;

    }

}
