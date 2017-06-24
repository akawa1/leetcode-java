package com.leetcode.alg;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution151 {
	public static String reverseWords(String s) {
		LinkedList<Integer[]> stack = new LinkedList<>();
		StringBuilder builder = new StringBuilder();
		char[] data = (s + " ").toCharArray();
		int start = 0, end = 0;
		boolean started = false;
		for (int i = 0; i < data.length; i++) {
			if (started && data[i] == ' ') {
				end = i;
				started = false;
				stack.addFirst(new Integer[] { start, end });
			} else if (!started && data[i] != ' ') {
				start = i;
				started = true;
			}
		}
		for (Integer[] pair : stack) {
			builder.append(Arrays.copyOfRange(data, pair[0], pair[1]));
			builder.append(' ');
		}
		return builder.toString().trim();
	}
}
