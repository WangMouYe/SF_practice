package com.example.demo.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int count = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    count = Math.max(count, i - stack.peek());
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "";
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.longestValidParentheses(s));
    }


}
