package com.example.demo.simple;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ReverseInteger {

    private static int reverseInteger(int x) {
        String str = x+"";
        boolean fu = false;
        if (str.contains("-")){
            str = str.substring(1);
            fu = true;
        }

        StringBuilder reverse = new StringBuilder(str).reverse();

        if (fu) reverse.insert(0,"-");

        str = reverse.toString();
        try {
            int res = Integer.valueOf(str);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = reverseInteger(-18);
        System.out.println(i);
    }

}
