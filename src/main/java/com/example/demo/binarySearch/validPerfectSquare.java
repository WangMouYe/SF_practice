package com.example.demo.binarySearch;

/**
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 *
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class validPerfectSquare {
    /**
     * 二分查找
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int low = 0, high = num;
        while (low <= high){
            int mid = low + ((high-low)>>1);
            long sqrt = (long) mid * mid;
            if (sqrt < num)
                low = mid +1;
            else if (sqrt > num)
                high = mid -1;
            else
                return true;
        }
        return false;
    }


    /**
     * 数学解法
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        int i = 1;
        while (num>0){
            num -= i;
            i+=2;
        }
        return num == 0;
    }
}
