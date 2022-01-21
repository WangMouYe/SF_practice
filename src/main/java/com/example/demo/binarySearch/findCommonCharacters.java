package com.example.demo.binarySearch;

import org.omg.CORBA.INTERNAL;
import sun.java2d.pipe.SolidTextRenderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1002. 查找共用字符
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
 * 示例 1：
 * 输入：words = ["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * 输入：words = ["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * https://leetcode-cn.com/problems/find-common-characters/
 */
public class findCommonCharacters {
    public List<String> commonChars(String[] words) {
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
        return list;
    }
    public List<String> commonChars1(String[] words) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;

    }
    public static void main(String[] args) {
//        String fir = "bool";
//        String[] split = fir.split("");
//        System.out.println(Arrays.toString(split));
        String [] words = new String[]{"cool","lock","cook"};
        findCommonCharacters f = new findCommonCharacters();
        List<String> strings = f.commonChars(words);
        System.out.println(strings.toString());
    }






}
