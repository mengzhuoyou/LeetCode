package com.company;

public class Leetcode_044_WildCardMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[m+1][n+1];

            dp[0][0] = true;
            for(int j = 0; j < n;j++)
                if(p.charAt(j) == '*' && dp[0][j])
                    dp[0][j+1] = true;

            for(int i = 0;i < n;i++){
                for(int j = 0;j < m;j++){
                    if(s.charAt(j) == p.charAt(i)) dp[j+1][i+1] = dp[j][i];
                    else if(p.charAt(i) == '?') dp[j+1][i+1] = dp[j][i];
                    else if(p.charAt(i) == '*') {
                        dp[j+1][i+1] = dp[j+1][i] || dp[j][i] || dp[j][i+1];
                    }
                }
            }

            return dp[m][n];
        }
    }
}
