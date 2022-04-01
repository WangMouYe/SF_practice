package com.example.demo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 2 3 4
 *
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length()==0) return list;
        Map<Character,String> map = new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        dfs(list,map,digits,0,new StringBuffer());
        return list;
    }

    private void dfs(List<String> list, Map<Character, String> map, String digits, int index, StringBuffer sb) {
        if (index==digits.length()){
            list.add(sb.toString());
        }else {
            char digit = digits.charAt(index);
            String s = map.get(digit);
            int sCount = s.length();
            for (int i=0;i<sCount;i++){
                sb.append(s.charAt(i));
                dfs(list,map,digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }


    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber n = new LetterCombinationsOfAPhoneNumber();
        System.out.println(n.letterCombinations("2356").toString());
    }

}
