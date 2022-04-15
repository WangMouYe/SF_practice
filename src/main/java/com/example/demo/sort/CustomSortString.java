package com.example.demo.sort;

import java.nio.channels.Channel;
import java.util.*;

/**
 * 791. 自定义字符串排序
 * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 * 返回 满足这个性质的 s 的任意排列 。
 * 示例 1:
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
 * 因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
 * 示例 2:
 * 输入: order = "cbafg", s = "abcd"
 * 输出: "cbad"
 * https://leetcode-cn.com/problems/custom-sort-string/
 */
public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i =0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        List<Character> tmp = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c))list.add(c);
            else tmp.add(c);
        }
        list.sort((a,b)->{return map.get(a)-map.get(b);});
        list.addAll(tmp);
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomSortString s = new CustomSortString();
        System.out.println(s.customSortString("cba","abcd"));
    }


}
