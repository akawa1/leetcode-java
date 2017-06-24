package com.leetcode.alg;

public class Solution287 {
	public static int findDuplicate(int[] nums) {
		if (nums.length < 2) {
			return -1;
		}
		int one = 0, two = 0;
		do {
			one = nums[one];
			two = nums[nums[two]];
		} while (one != two);

		one = 0;
		do {
			one = nums[one];
			two = nums[two];
		} while (one != two);

		return one;
	}
	
	public static void test() {
		int[] nums = {1,2,3,4,5,6,7,5};
		System.out.println(findDuplicate(nums));
	}
}