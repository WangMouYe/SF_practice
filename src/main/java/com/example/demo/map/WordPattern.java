package com.example.demo.map;

import sun.plugin.services.WPlatformService;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * https://leetcode-cn.com/problems/word-pattern/
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String [] words = s.split(" ");
        if (pattern.length()!=words.length){
            return false;
        }
        Map<Object,Integer> map = new HashMap<>();
        for (Integer i=0;i<words.length;i++){
            if (map.put(pattern.charAt(i),i)!=map.put(words[i],i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba","dog cat cat fish"));
    }
}
