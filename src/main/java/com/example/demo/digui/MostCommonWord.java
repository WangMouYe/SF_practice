package com.example.demo.digui;



import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * 示例：
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 * 链接：https://leetcode.cn/problems/most-common-word
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String result = paragraph.replaceAll("\\p{Punct}", " ");
        result = result.toLowerCase();
        String[] split = result.split(" ");
        Map<String,Integer> map = new HashMap<>();
        List<String> strings = Arrays.asList(banned);
        for (String s : split) {
            if (!strings.contains(s) && !(s == null || "".equals(s))){
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        Integer max = Integer.MIN_VALUE;
        String res = "";
        for (String s : map.keySet()) {
            if (map.get(s) > max){
                max = map.get(s);
                res = s;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MostCommonWord mos = new MostCommonWord();
        System.out.println(mos.mostCommonWord("a, a, a, a, b,b,b,c, c",new String[]{"a"}));

    }


}
