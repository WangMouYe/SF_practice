package com.example.demo.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * 示例 1：
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (s.length()<k)return 0;
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c)<k){
                int ans = 0;
                for (String t : s.split(String.valueOf(c))) {
                    ans = Math.max(ans, longestSubstring(t, k));
                }
                return ans;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingCharacters ls = new LongestSubstringWithAtLeastKRepeatingCharacters();
        System.out.println(ls.longestSubstring("ababbc",2));
    }

}
