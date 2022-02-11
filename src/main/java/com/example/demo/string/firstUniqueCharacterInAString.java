package com.example.demo.string;

import com.sun.scenario.effect.impl.sw.java.JSWRendererDelegate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class firstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
       int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,-1);
            }else map.put(c,i);
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos <first ){
                first = pos;
            }
        }
        if (first == n) return -1;
        return first;
    }
    //还可以拼串

    public static void main(String[] args) {
        String s = "leetcode";
        firstUniqueCharacterInAString f = new firstUniqueCharacterInAString();
        System.out.println(f.firstUniqChar(s));
    }

}
