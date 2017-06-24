package com.leetcode.alg;

import com.leetcode.adt.TreeNode;

public class Solution404 {
	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves(root, false);
	}

	public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return isLeft ? root.val : 0;
		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}
}