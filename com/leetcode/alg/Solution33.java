package com.leetcode.alg;

public class Solution33 {
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			if (target < nums[l] && target > nums[r])
				return -1;
			int mid = (l + r) / 2;
			if (target == nums[mid])
				return mid;
			else if (target > nums[mid]) {
				if (nums[mid]<nums[l]&&target>nums[r])
					r = mid - 1;
				else
					l = mid + 1;
			} else { // <
				if (nums[mid]<nums[r]&&target<nums[l])
					l = mid + 1;
				else
					r = mid - 1;
			}
			// else if(nums[mid]>=nums[l]) {
			// if(nums[mid]>target) return bsearch(nums, l, mid-1, target);
			// if(nums[mid]<target) l=mid+1;
			// }
			// else if(nums[mid]<=nums[r]) {
			// if(nums[mid]<target) return bsearch(nums, mid+1, r, target);
			// if(nums[mid]>target) r=mid-1;
			// }
		}
		return -1;
	}
	static class Test {
		public static void main(String[] args) {
			System.out.println(search(new int[]{4,5,6,7,8,1,2,3}, 8));
		}
	}
}
