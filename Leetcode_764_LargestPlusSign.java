package com.company;

import java.util.Arrays;

public class Leetcode_764_LargestPlusSign {
    class Solution {
        public int orderOfLargestPlusSign(int N, int[][] mines) {
            int[][] grid = new int[N][N];

            for(int[] rows : grid)
                Arrays.fill(rows, N);

            for(int[] mine : mines)
                grid[mine[0]][mine[1]] = 0;

            for(int i = 0;i < N;i++) {

                for(int j = 0, l = 0;j < N;j++) {
                    // j is a column index, iterate from left to right
                    // every time check how far left it can reach.
                    // if grid[i][j] is 0, l needs to start over from 0 again, otherwise increment
                    grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l+1));
                }

                for(int k = 0, u = 0;k < N;k++) {
                    // k is a row index, iterate from up to down
                    // every time check how up it can reach
                    grid[k][i] = Math.min(grid[k][i], u = (grid[k][i] == 0 ? 0 : u+1));
                }

                for(int j = N-1, r = 0;j >= 0;j--) {
                    // j is a column index, iterate from right to left
                    // every time check how far right it can reach.
                    grid[i][j] = Math.min(grid[i][j], r = (grid[i][j] == 0 ? 0 : r+1));
                }

                for(int k = N-1, d = 0;k >= 0;k--) {
                    // k is a row index, iterate from down to up
                    // every time check how down it can reach
                    grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d+1));
                }
            }

            int res = 0;
            for(int i = 0;i < N;i++)
                for(int j = 0;j < N;j++)
                    res = Math.max(res, grid[i][j]);

            return res;
        }
    }
}
