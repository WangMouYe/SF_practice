package com.example.demo.queueAndStack;

import javax.swing.text.html.ListView;
import java.util.*;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 */
public class validParentheses {
    public boolean isValid(String s) {
        int n = s.length();
        if(n%2==1) return false;
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.peek()!=c)return false;
                stack.pop();
            }else stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        validParentheses v = new validParentheses();
        System.out.println(v.isValid(s));

    }


}
