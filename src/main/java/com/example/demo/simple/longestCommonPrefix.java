package com.example.demo.simple;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        int n = strs.length;
        String result = strs[0];

        for (int i=1; i<n; i++){
            result = compareAndAppend(result,strs[i]);
            if (result.length()==0)break;
        }
        return result;
    }

    private static String compareAndAppend(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int index = 0;
        while(index<minLength && s1.charAt(index)==s2.charAt(index)){
            index ++;
        }
        return s1.substring(0,index);
    }

    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }


}
