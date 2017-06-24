package com.leetcode.alg;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Solution264 {
	public static int nthUglyNumber(int n) {
		if (n == 1)
			return 1;
		
		TreeSet<Long> set = new TreeSet<>();
		List<Integer> fact = Arrays.asList(2, 3, 5);

		set.add(1L);
		while (true) {
			Long min = set.pollFirst();
			if (--n==0) {
				return min.intValue();
			}
			for (Integer p : fact) {
				Long m = p * min;
				set.add(m);
			}
		}
	}
	
	static class Test {
		public static void main(String[] args) {
			System.out.println(nthUglyNumber(10));
		}
	}
}
