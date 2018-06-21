package com.company;

import java.util.Arrays;

public class Leetcode_576_OutofBoundaryPaths {

    // Time Complexity: O(m*n*N)
    // Space complexity : O(m∗n∗N).
    class Solution {
        int M = 1000000007;
        int[][][] memo;

        public int findPaths(int m, int n, int N, int i, int j) {
            memo = new int[m][n][N+1];

            for(int[][] row : memo)
                for(int[] arr : row)
                    Arrays.fill(arr,-1);

            return findPath(m,n,N,i,j) % M;
        }

        public int findPath(int m, int n, int N, int i, int j) {
            if(i < 0 || j < 0 || i == m || j == n)
                return 1;
            if(N == 0)
                return 0;

            if(memo[i][j][N] >= 0)
                return memo[i][j][N];

            memo[i][j][N] = ((findPath(m,n,N-1,i-1,j) % M
                    +findPath(m,n,N-1,i+1,j) % M) % M
                    +(findPath(m,n,N-1,i,j-1) % M
                    +findPath(m,n,N-1,i,j+1) % M) % M) % M;

            return memo[i][j][N];
        }
    }


}
