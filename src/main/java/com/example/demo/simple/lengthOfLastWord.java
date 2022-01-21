package com.example.demo.simple;

/**
 * 58. 最后一个单词的长度
 *
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 *
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        //0.字符串为空直接返回0
        if (s.equals("") || s==null) return 0;
        //1.如果字符串中不存在空格 直接返回长度
        if (!s.contains(" ")) return s.length();
        //2.找最后一个空格之后的字符串 并获取其长度
        s = s.trim();
        int last = s.lastIndexOf(" ");
        String str = s.substring(last+1);
        System.out.println(str);
        return str.length();
//        s = s.trim();
//        return s.length() - s.lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
//        System.out.println(lengthOfLastWord("joyboy"));
//        System.out.println(lengthOfLastWord("Hello World"));
    }

}
