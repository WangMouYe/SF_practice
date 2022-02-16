package com.example.demo.linked;

import com.example.demo.base.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class removeDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)return head;
       ListNode node = head;
       while (node.next!=null){
           if (node.val == node.next.val){
               node.next = node.next.next;
           }else {
               node = node.next;
           }
       }
       return head;
    }
}
