package com.leetcode.adt;

// Definition for singly-linked list.
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		ListNode node = this;
		while (node!=null) {
			builder.append(" "+ node.val);
			node = node.next;
		}
		return builder.toString();
	}
}
