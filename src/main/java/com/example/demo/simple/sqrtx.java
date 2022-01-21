package com.example.demo.simple;

/**
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 *
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class sqrtx {

    public static int mySqrt(int x) {
        double sqrt = Math.sqrt(x);
        String str = sqrt+"";
        if (str.contains(".")){
            str = str.substring(0,str.indexOf("."));
        }
        return Integer.valueOf(str);
    }

    public static int mySqrt1(int x){
        int low = 0, high = x, ans = -1;
        while (low <= high){
            int mid = low + ((high - low)>>1);
            if ((long) mid*mid <= x){
                ans = mid;
                low = mid + 1;
            }else high = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = mySqrt(8);
        System.out.println(i);
        int i1 = mySqrt1(8);
        System.out.println(i1);
    }

}
