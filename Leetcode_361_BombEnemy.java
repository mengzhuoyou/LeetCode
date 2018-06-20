package com.company;

public class Leetcode_361_BombEnemy {
    /*
    rowCnt: 到下一个墙之前，敌人的个数
    colCnt[j]: 表示第j列到下一个墙之前，敌人的个数

    time complexity: O(mn)
    space: O(n)
*/

    class Solution {
        public int maxKilledEnemies(char[][] grid) {
            if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

            int m = grid.length;//row
            int n = grid[0].length;//col

            int[] colCnt = new int[n];
            int rowCnt = 0;

            int max = 0;

            for(int i = 0;i < m; i++) {
                for(int j = 0;j < n; j++) {
                    if(j == 0 || grid[i][j-1] == 'W') {
                        rowCnt = 0;
                        int k = j;
                        while(k < n && grid[i][k] != 'W') {
                            if(grid[i][k] == 'E')
                                rowCnt++;
                            k++;
                        }
                    }

                    if(i == 0 || grid[i-1][j] == 'W') {
                        colCnt[j] = 0;
                        int k = i;
                        while(k < m && grid[k][j] != 'W') {
                            if(grid[k][j] == 'E')
                                colCnt[j]++;
                            k++;
                        }
                    }

                    if(grid[i][j] == '0') {
                        max = Math.max(max, rowCnt+colCnt[j]);
                    }
                }
            }

            return max;
        }
    }
}
