package com.company;

public class leetcode_200_NumberOfIslands {
    class Solution {
        /**
         * DFS search.
         * When we meet a '1', we mark all connected '1's to 0, count++.
         * Time Complexity: O(m*n).
         * Space Complexity: worst case : full of '1's, O(m*n).
         */
        private int x;
        private int y;
        public int numIslands(char[][] grid) {
            x = grid.length;
            if(x == 0) return 0;

            y = grid[0].length;
            int count = 0;

            for(int i = 0;i < x;i++)
                for(int j = 0;j < y;j++){
                    if(grid[i][j] == '1'){
                        dfs(grid,i,j);
                        count++;
                    }
                }

            return count;
        }

        public void dfs(char[][] grid, int i,int j){
            if(i < 0 || j < 0 || i >= x || j >= y || grid[i][j] != '1') return;
            grid[i][j] = '0';

            dfs(grid,i-1,j);
            dfs(grid,i,j-1);
            dfs(grid,i+1,j);
            dfs(grid,i,j+1);
        }
    }
}
