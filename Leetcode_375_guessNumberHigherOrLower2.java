package com.company;

public class Leetcode_375_guessNumberHigherOrLower2 {
    /*
    we will fill in the entries diagonally;
    time: O(n^3)
    space: O(n^2)
*/
    class Solution {
        public int getMoneyAmount(int n) {
            int[][] dp = new int[n+1][n+1];

            for(int len = 2;len <= n;len++) {
                for(int i = 1;i <= n - len + 1;i++) {
                    int min = Integer.MAX_VALUE;
                    for(int j = i;j < i + len -1;j++) {
                        int res = j + Math.max(dp[i][j-1], dp[j+1][i+len-1]);
                        min = Math.min(min,res);
                    }
                    dp[i][i+len-1] = min;
                }
            }

            return dp[1][n];
        }
    }
}
