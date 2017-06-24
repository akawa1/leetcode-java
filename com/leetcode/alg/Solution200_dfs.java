package com.leetcode.alg;

public class Solution200_dfs {
	private int M, N;

	public int numIslands(char[][] grid) {
		int cnt = 0;
		if (grid == null)
			return 0;
		if ((M = grid.length) == 0)
			return 0;
		if ((N = grid[0].length) == 0)
			return 0;
		for (int m = 0; m < M; m++)
			for (int n = 0; n < N; n++)
				if (grid[m][n] == '1') {
					cnt++;
					dfs(grid, m, n);
				}
		return cnt;
	}

	private void dfs(char[][] grid, int m, int n) {
		if (m < 0 || m + 1 > M || n < 0 || n + 1 > N || grid[m][n] != '1')
			return;
		grid[m][n] = '*';
		dfs(grid, m, n + 1);
		dfs(grid, m, n - 1);
		dfs(grid, m + 1, n);
		dfs(grid, m - 1, n);
	}
}
