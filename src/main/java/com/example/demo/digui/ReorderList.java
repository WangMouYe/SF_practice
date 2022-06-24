package com.example.demo.digui;

import com.example.demo.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * https://leetcode.cn/problems/reorder-list/
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)return;

        // 1. 找中点，让slow指向中点，或左中点位置
        ListNode slow = head, fast = head.next;
        while (fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 断开中点，反转后半部分
        ListNode head2 = null, next = slow.next;
        slow.next = null;
        slow = next;
        while(slow != null) {
            next = slow.next;
            slow.next = head2;
            head2 = slow;
            slow = next;
        }

        // 3. 合并链表head和head2
        ListNode curr = head;
        ListNode curr2 = head2;
        while(curr != null && curr2!=null) {
            next = curr.next;
            curr.next = curr2;
            curr2 = curr2.next;
            curr.next.next = next;
            curr = next;
        }

    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> list2 = new ArrayList<>();
        int n = list.size();
        int index = 0;
        for (int i=0;i<n;i++){
            if (i%2==0){
                list2.add(list.get(index));
            }else {
                list2.add(list.get(n-index-1));
                index++;
            }
        }
        System.out.println(list.toString());
        System.out.println(list2.toString());
    }


}
