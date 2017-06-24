package com.leetcode.alg;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution200_bfs {
	public int numIslands(char[][] grid) {
		if (grid == null)
			return 0;
		int M;
		if ((M = grid.length) == 0)
			return 0;
		int N;
		if ((N = grid[0].length) == 0)
			return 0;
		int cnt = 0;
		for (int m = 0; m < M; m++)
			for (int n = 0; n < N; n++)
				if (grid[m][n] == '1') {
					cnt++;
					bfs(grid, m, n, M, N);
				}
		return cnt;
	}

	private void bfs(char[][] grid, int m, int n, int M, int N) {
		if (m < 0 || m + 1 > M || n < 0 || n + 1 > N)
			return;
		if (grid[m][n] != '1')
			return;
		Queue<Integer> queue = new LinkedList<>();
		grid[m][n] = '*';
		Collections.addAll(queue, m, n);
		while (!queue.isEmpty()) {
			m = queue.poll();
			n = queue.poll();
			if (m > 0 && grid[m - 1][n] == '1') {
				grid[m - 1][n] = '*';
				Collections.addAll(queue, m - 1, n);
			}
			if (m + 1 < M && grid[m + 1][n] == '1') {
				grid[m + 1][n] = '*';
				Collections.addAll(queue, m + 1, n);
			}
			if (n > 0 && grid[m][n - 1] == '1') {
				grid[m][n - 1] = '*';
				Collections.addAll(queue, m, n - 1);
			}
			if (n + 1 < N && grid[m][n + 1] == '1') {
				grid[m][n + 1] = '*';
				Collections.addAll(queue, m, n + 1);
			}
		}
	}
}