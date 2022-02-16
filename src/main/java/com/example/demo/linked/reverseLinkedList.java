package com.example.demo.linked;

import com.example.demo.base.ListNode;

/**
 *206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)return head;
        ListNode prev = null;
        ListNode node = head;
        while (node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
