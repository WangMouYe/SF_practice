package com.example.demo.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * 提示：
 * 1 <= n <= 8
 * https://leetcode.cn/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        handler(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    private void handler(List<String> ans, StringBuilder sb, int open, int close, int max) {
        if (sb.length()==max*2){
            ans.add(sb.toString());
            return;
        }
        if (open<max){
            sb.append("(");
            handler(ans,sb,open+1,close,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if (close<open){
            sb.append(")");
            handler(ans,sb,open,close+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3).toString());


    }


}
