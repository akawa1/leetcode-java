package com.leetcode.alg;

import java.util.HashSet;
import java.util.Set;

public class Solution399 {
	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		double[] ans = new double[queries.length];

		for (int i = 0; i < queries.length; i++) {
			Set<String> visited = new HashSet<String>();
			double tmp = DFS(queries[i][0], queries[i][1], equations, values, visited);
			ans[i] = tmp == Double.NEGATIVE_INFINITY ? -1 : tmp;
		}

		return ans;
	}

	private static double DFS(String start, String end, String[][] equations, double[] values, Set<String> visited) {
		for (int i = 0; i < equations.length; i++) {
			if (start.equals(equations[i][0])) {
				if (end.equals(equations[i][1]))
					return values[i];
				if (!visited.contains(equations[i][1])) {
					visited.add(start);
					double tmp = DFS(equations[i][1], end, equations, values, visited);
					if (tmp != Double.NEGATIVE_INFINITY)
						return values[i] * tmp;
				}
			}
			if (start.equals(equations[i][1])) {
				if (end.equals(equations[i][0]))
					return 1.0 / values[i];
				if (!visited.contains(equations[i][0])) {
					visited.add(start);
					double tmp = DFS(equations[i][0], end, equations, values, visited);
					if (tmp != Double.NEGATIVE_INFINITY)
						return 1.0 / values[i] * tmp;
				}
			}
		}
		return Double.NEGATIVE_INFINITY;
	}

	public static void test() {
		String[][] equations = { { "a", "b" }, { "b", "c" } };
		double[] values = { 2.0, 3.0 };
		String[][] queries = { { "a", "c" }, { "b", "c" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };
		for (double a : calcEquation(equations, values, queries)) {
			System.out.println(a);
		}
	}
}