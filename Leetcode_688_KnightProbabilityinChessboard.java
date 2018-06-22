package com.company;

public class Leetcode_688_KnightProbabilityinChessboard {
    class Solution {
        public double knightProbability(int N, int K, int r, int c) {
            int[] dr = new int[] {-1, -2, -2, -1, 1, 2, 2, 1};
            int[] dc = new int[] {-2, -1,  1,  2, 2, 1,-1,-2};

            double[][] f = new double[N][N];

            f[r][c] = 1;

            for(int k = 1;k <= K;k++) {
                double[][] tmp = new double[N][N];
                for(int i = 0;i < N;i++){
                    for(int j = 0;j < N;j++){
                        for(int d = 0; d < 8; d++){
                            int rr = i + dr[d];
                            int cc = j + dc[d];

                            if(rr >= 0 && rr < N && cc >= 0 && cc < N) {
                                tmp[i][j] += f[rr][cc] / 8;
                            }
                        }
                    }
                }
                f = tmp;
            }

            double res = 0;
            for(int i = 0;i < N;i++)
                for(int j = 0;j < N;j++)
                    res += f[i][j];

            return res;

        }
    }
}
