package com.company;

public class Leetcode_221_MaximalSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix == null || matrix.length == 0) return 0;

            int m = matrix.length;
            int n = matrix[0].length;
            int max = 0;

            int[] p = new int[n];

            for(int j = 0;j < n;j++) {
                p[j] = matrix[0][j] - '0';
                max = Math.max(max, p[j]);
            }

            for(int i = 1;i < m;i++) {
                int[] tmp = new int[n];
                for(int j = 0;j < n;j++) {
                    if(j == 0) tmp[0] = matrix[i][j] - '0';
                    else if(matrix[i][j] == '0') tmp[j] = 0;
                    else {
                        tmp[j] = Math.min(p[j-1], Math.min(p[j], tmp[j-1])) + 1;
                    }
                    max = Math.max(max, tmp[j]);
                }
                p = tmp;
            }

            return max*max;
        }
    }
}
