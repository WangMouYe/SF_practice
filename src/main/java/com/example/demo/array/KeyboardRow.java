package com.example.demo.array;

import java.util.*;

/**
 * 500. 键盘行
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * American keyboard
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * https://leetcode-cn.com/problems/keyboard-row/
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c,1);
        }
        for (char c : s2.toCharArray()) {
            map.put(c,2);
        }
        for (char c : s3.toCharArray()) {
            map.put(c,3);
        }
        List<String> list = new ArrayList<>();
        int n = words.length;

        for (int i=0;i<n;i++){
            String str = words[i];
            char[] chars = str.toCharArray();
            Integer b = map.get(chars[0]);
            list.add(str);
            for (int j=1;j<str.length();j++){
                if (!map.get(chars[j]).equals(b)){
                    list.remove(str);
                    break;
                }
            }
        }

        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        KeyboardRow row = new KeyboardRow();
        String [] words = {"Hello","Alaska","Dad","Peace"};
        String[] rowWords = row.findWords(words);
        System.out.println(Arrays.toString(rowWords));
    }

}
