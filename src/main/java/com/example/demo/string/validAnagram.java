package com.example.demo.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class validAnagram {
    public boolean isAnagram(String s, String t) {
        String [] words = new String[]{s,t};
        int sLength = s.length();
        int tLength = t.length();
        int minFreq[] = new int[26];
        Arrays.fill(minFreq,Integer.MAX_VALUE);
        for (String word : words) {
            int [] freq = new int[26];
            int n = word.length();
            for (int i=0;i<n;i++){
                char c = word.charAt(i);
                freq[c-'a']++;
            }
            for (int i=0;i<26;i++){
                minFreq[i] = Math.min(minFreq[i],freq[i]);
            }
        }

        ArrayList<Object> list = new ArrayList<>();
        for (int i=0;i<26;i++){
            for (int j=0;j<minFreq[i];j++){
                list.add(String.valueOf((char)(i+'a')));
            }
        }
        if (list.size()==sLength && sLength==tLength)return true;
        else return false;
    }





}
