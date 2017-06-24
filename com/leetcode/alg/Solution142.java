package com.leetcode.alg;

import com.leetcode.adt.ListNode;

public class Solution142 {
	public static ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				fast = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return fast;
			}
		}
		return null;
	}

	public static void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;
		ListNode ans = detectCycle(n1);
		if (ans == null) {
			System.out.println("null");
		} else {
			System.out.println(ans.val);
		}
	}
}
