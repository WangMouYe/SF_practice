package com.example.demo.math;

import java.math.BigDecimal;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    int LIMIT = -1073741824; // MIN 的一半
    public int divide(int a, int b) {
        if (a == MIN && b == -1) return MAX;
        boolean flag = false;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) flag = true;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int ans = 0;
        while (a <= b){
            int c = b, d = -1;
            while (c >= LIMIT && d >= LIMIT && c >= a - c){
                c += c; d += d;
            }
            a -= c;
            ans += d;
        }
        return flag ? ans : -ans;
    }

    public static void main(String[] args) {
        DivideTwoIntegers i = new DivideTwoIntegers();
        System.out.println(i.divide(-2147483648,-1));
//        -2147483648
//                -1
    }

}
