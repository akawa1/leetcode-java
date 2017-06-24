package com.leetcode.alg;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution15 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans3 = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> ans2 = twoSum(nums, -nums[i], i + 1);
			for (List<Integer> list : ans2) {
				list.add(nums[i]);
				ans3.add(list);
			}
		}
		return ans3;
	}

	public static List<List<Integer>> twoSum(int[] nums, int target, int i) {
		List<List<Integer>> ans2 = new LinkedList<>();
		Map<Integer, Boolean> map = new HashMap<>();
		for (int j = i; j < nums.length; j++) {
			int other = target - nums[j];
			if (map.containsKey(other)) {
				if(map.get(other)) continue;
				List<Integer> list = new LinkedList<>();
				Collections.addAll(list, nums[j], other);
				ans2.add(list);
				map.put(other, true);
//				map.put(nums[j], ture);
			} else {
				map.put(nums[j], false);
			}
		}
		return ans2;
	}
}