package com.leetcode.alg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution140 {
	public static List<String> wordBreak(String s, List<String> wordDict) {
		Map<Integer, List<String>> dict = new HashMap<>();
		for (String word : wordDict) {
			int len = word.length();
			List<String> list = dict.get(len);
			if (list == null)
				list = new LinkedList<>();
			list.add(word);
			dict.put(len, list);
		}

		@SuppressWarnings("unchecked")
		List<String>[] cache = (List<String>[]) new LinkedList[s.length()];

		return dfs(s, 0, dict, cache);
	}

	private static List<String> dfs(String s, int pos, Map<Integer, List<String>> dict, List<String>[] cache) {
		List<String> ans = new LinkedList<>();
		if (pos == s.length()) {
			ans.add("");
			return ans;
		}

		if (cache[pos] != null) {
			return cache[pos];
		}

		for (int k : dict.keySet()) {
			if (pos + k > s.length())
				continue;
			String word = s.substring(pos, pos + k);
			if (dict.get(k).contains(word)) {
				List<String> subAns = dfs(s, pos + k, dict, cache);
				for (String subWord : subAns) {
					ans.add(word + (subWord.equals("") ? "" : " ") + subWord);
				}
			}
		}

		cache[pos] = ans;
		return ans;
	}

	static class Test {
		public static void main(String[] args) {
			System.out.println(wordBreak("catsanddog",
					new LinkedList<String>(Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" }))));
		}
	}
}
