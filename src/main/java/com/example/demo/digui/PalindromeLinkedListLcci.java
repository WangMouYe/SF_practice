package com.example.demo.digui;

import com.example.demo.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true
 * https://leetcode.cn/problems/palindrome-linked-list-lcci/
 */
public class PalindromeLinkedListLcci {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        for (int i=0;i<list.size();i++){
            if (list.get(i)!=list.get(list.size()-i-1))return false;
        }
        return true;
    }
}
