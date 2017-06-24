package com.leetcode.alg;

public class Solution91 {
    public int numDecodings(String s) {
        if (s==null || s.isEmpty()) return 0;
        
        int[] cache = new int[s.length()];
        for(int i=0; i<cache.length; i++)
            cache[i] = -1;
            
        return dfs(s, 0, cache);
    }
    
    private int dfs(String s, int pos, int[] cache) {
        if (pos == cache.length) return 1;
        if (s.charAt(pos) == '0') return 0;
        if (cache[pos] != -1) return cache[pos];
        
        int res = dfs(s, pos+1, cache);
        if (pos+1 < cache.length && Integer.parseInt(s.substring(pos, pos+2)) <= 26) 
            res += dfs(s, pos+2, cache);
            
        cache[pos] = res;
        return res;
    }
}