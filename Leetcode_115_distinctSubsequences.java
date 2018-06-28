package com.company;

public class Leetcode_115_distinctSubsequences {
    /*
    dp[i][j]: the number of distinct subsequences in s[0,j-1] which equals to t[0, i-1]
    final result: dp[m][n] = dp[t.length()][s.length()]
*/

    class Solution {
        public int numDistinct(String s, String t) {
            int m = t.length();
            int n = s.length();

            int[][] dp = new int[m+1][n+1];

            //every substring in S can have 1 time empty string in T
            for(int j = 0;j <= n;j++)
                dp[0][j] = 1;

            for(int i = 1;i <= m;i++) {
                for(int j = 1;j <= n;j++) {
                    if(t.charAt(i-1) != s.charAt(j-1)) {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                    }
                }
            }

            return dp[m][n];

        }
    }
}
