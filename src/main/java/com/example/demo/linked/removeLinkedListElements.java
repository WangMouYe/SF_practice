package com.example.demo.linked;

import com.example.demo.base.ListNode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class removeLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head ==null)return head;

        head.next = removeElements(head.next,val);
        return head.val==val?head.next:head;
    }
}
