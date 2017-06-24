package com.leetcode.alg;

public class Solution48 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				matrix[i][j] ^= matrix[n - 1 - j][n - 1 - i];
				matrix[n - 1 - j][n - 1 - i] ^= matrix[i][j];
				matrix[i][j] ^= matrix[n - 1 - j][n - 1 - i];
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] ^= matrix[n - 1 - i][j];
				matrix[n - 1 - i][j] ^= matrix[i][j];
				matrix[i][j] ^= matrix[n - 1 - i][j];
			}
		}
	}
}