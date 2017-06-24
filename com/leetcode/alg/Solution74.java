package com.leetcode.alg;

public class Solution74 {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int M = matrix.length;
		if (M == 0)
			return false;
		int N = matrix[M - 1].length;
		if (N == 0 || target < matrix[0][0] || target > matrix[M - 1][N - 1])
			return false;
		if (M == 1)
			return searchRow(matrix[0], target);
		int i = 0, j = M - 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (matrix[mid][0] <= target && matrix[mid + 1][0] > target)
				return searchRow(matrix[mid], target);
			else if (matrix[mid + 1][0] <= target)
				i = mid + 1;
			else if (matrix[mid][0] > target)
				j = mid - 1;
		}
		return searchRow(matrix[i], target);
	}

	private static boolean searchRow(int[] row, int target) {
		int l = 0, r = row.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (row[mid] == target)
				return true;
			else if (row[mid] > target)
				r = mid - 1;
			else if (row[mid] < target)
				l = mid + 1;
		}
		return false;
	}

	static class Test {
		public static void main(String[] args) {
			boolean ok = searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } }, 3);
			System.out.println(ok);
		}
		// [1, 3, 5, 7],
		// [10, 11, 16, 20],
		// [23, 30, 34, 50]
	}
}
