package com.leetcode.alg;

import java.util.ArrayList;
import java.util.List;

public class Solution264_dp {
	public static int nthUglyNumber(int n) {
		List<Integer> ugly = new ArrayList<>();
		ugly.add(1);
		
		int p2 = 0, p3 = 0, p5 = 0;
		while(ugly.size()<n) {
			int v2 = ugly.get(p2) * 2;
			int v3 = ugly.get(p3) * 3;
			int v5 = ugly.get(p5) * 5;
			int min = Math.min(v2, Math.min(v3, v5));
			ugly.add(min);
			if (v2 == min) p2++;
			if (v3 == min) p3++;
			if (v5 == min) p5++;
		}
		return ugly.get(n-1);
	}
	
	static class Test {
		public static void main(String[] args) {
			System.out.println(nthUglyNumber(10));
		}
	}
}
