package com.company;

public class Leetcode_010_RegularExpressionMatching {
    /**
     1. p.charAt(i) == s.charAt(j) : dp[i][j] = dp[i-1][j-i];
     2. p.charAt(i) == "." : dp[i][j] = dp[i-1][j-1];
     3. p.charAt(i) == "*" :
     1. if p.charAt(i-1) != s.charAt(j) : dp[i][j] = dp[i-2][j]  //in this case, a* only counts as empty
     2. if p.charAt(i-1) == s.charAt(j) or p.charAt(i-1) == '.':
     dp[i][j] = dp[i][j-1]    //in this case, a* counts as multiple a
     or dp[i][j] = dp[i-1][j]   // in this case, a* counts as single a
     or dp[i][j] = dp[i-2][j]   // in this case, a* counts as empty
     */

    class Solution {
        public boolean isMatch(String s, String p) {
            int n = p.length(), m = s.length();
            boolean[][] dp = new boolean[n+1][m+1];

            dp[0][0] = true;
            for(int i = 0;i < n;i++)
                if(p.charAt(i) == '*' && dp[i-1][0])
                    dp[i+1][0] = true;   //p = 'c*a*b', s = 'aab'

            for(int i = 0; i < n;i++) {
                for(int j = 0;j < m;j++) {
                    if(p.charAt(i) == s.charAt(j))
                        dp[i+1][j+1] = dp[i][j];
                    else if(p.charAt(i) == '.')
                        dp[i+1][j+1] = dp[i][j];
                    else if(p.charAt(i) == '*') {
                        if(p.charAt(i-1) != s.charAt(j) && p.charAt(i-1) != '.')
                            dp[i+1][j+1] = dp[i-1][j+1];
                        else if(p.charAt(i-1) == '.' || p.charAt(i-1) == s.charAt(j))
                            dp[i+1][j+1] = dp[i-1][j+1] || dp[i][j+1] || dp[i+1][j];
                    }
                }
            }

            return dp[n][m];
        }
    }
}
