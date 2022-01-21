package com.example.demo.simple;

import java.util.List;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class removeDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)return head;
        ListNode cur = head;
        while (cur.next!=null){
            if (cur.val == cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }
}
