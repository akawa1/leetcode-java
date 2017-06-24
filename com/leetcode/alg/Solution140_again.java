package com.leetcode.alg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution140_again {
	public static List<String> wordBreak(String s, List<String> wordDict) {
		@SuppressWarnings("unchecked")
		List<String>[] cache = (List<String>[]) new List[s.length() + 1];
		cache[s.length()] = Arrays.asList("");
		return dfs(s, 0, wordDict, cache);
	}

	private static List<String> dfs(String s, int start, List<String> wordDict, List<String>[] cache) {
		if (cache[start] != null)
			return cache[start];
		List<String> ans = new LinkedList<>();
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				for (String suffix : dfs(s.substring(word.length()), start + word.length(), wordDict, cache))
					ans.add(word + (suffix.isEmpty() ? "" : " ") + suffix);
			}
		}
		cache[start]= ans;
		return ans;
	}

	static class Test {
		public static void main(String[] args) {
			System.out.println(wordBreak("catsanddog",
					new LinkedList<String>(Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" }))));
		}
	}
}
