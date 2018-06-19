package com.company;

public class Leetcode_206_ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }
    }
}
