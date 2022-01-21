package com.example.demo.simple;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class addBinary {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0){
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            sb.append(sum % 2);
        }
        while (i >= 0){
            int sum = carry;
            sum += a.charAt(i--) - '0';
            carry = sum / 2;
            sb.append(sum % 2);
        }
        while (j >= 0){
            int sum = carry;
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry==1)sb.append(carry);

        return sb.reverse().toString();
    }
}
