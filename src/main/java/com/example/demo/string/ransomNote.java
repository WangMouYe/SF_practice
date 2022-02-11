package com.example.demo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * https://leetcode-cn.com/problems/ransom-note/
 */
public class ransomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        //先统计ransom 各元素各几个 再与magazine比对一下
        String[] words = new String[]{ransomNote,magazine};
        int [] minFreq = new int[26];
        Arrays.fill(minFreq,Integer.MAX_VALUE);
        for (String word : words) {
            int [] freq = new int[26];
            int n = word.length();
            for (int i=0;i<n;i++){
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i=0;i<26;i++){
                minFreq[i] = Math.min(minFreq[i],freq[i]);
            }
        }
        List<String> list = new ArrayList<>();
        for (int i=0;i<26;i++){
            for (int j=0;j<minFreq[i];j++){
                list.add(String.valueOf((char)(i+'a')));
            }
        }
        int f = ransomNote.length();
        if (f==list.size())return true;

        return false;

    }


    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        ransomNote r = new ransomNote();
        System.out.println(r.canConstruct(ransomNote,magazine));
    }

}
