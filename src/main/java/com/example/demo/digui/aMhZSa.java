package com.example.demo.digui;

import com.example.demo.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 027. 回文链表
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * 示例 1：
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 * 输入: head = [1,2]
 * 输出: false
 * https://leetcode.cn/problems/aMhZSa/
 */
public class aMhZSa {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        for (int i=0;i<list.size();i++){
            if (!list.get(i).equals(list.get(list.size()-i-1))){
                return false;
            }
        }
        return true;
    }
}
