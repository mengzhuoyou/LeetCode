package com.company;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_051_NQueens {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0;i < n;i++)
                for (int j = 0;j < n;j++)
                    board[i][j] = '.';
            List<List<String>> res = new ArrayList<>();
            dfs(res, board, 0, n);
            return res;
        }

        public void dfs(List<List<String>> res, char[][] board, int idx, int n) {
            if (idx == n) {
                res.add(construct(board));
                return;
            }

            // idx < n, so we need to put new queen on the current row,row number is equal to idx
            for (int j = 0;j < n;j++) {
                if (isValidate(board, idx, j)) {
                    board[idx][j] = 'Q';
                    dfs(res, board, idx+1, n);
                    board[idx][j] = '.';
                }
            }
        }

        public boolean isValidate(char[][] board, int row, int col) {
            for (int i = 0;i < row;i++) {
                for (int j = 0; j < board.length; j++) {
                    if(board[i][j] == 'Q' && (j == col || (row + col) == (i + j) || (row - col) == (i - j))) {
                        return false;
                    }
                }
            }

            return true;
        }

        public List<String> construct(char[][] board) {
            List<String> curRes = new ArrayList<>();
            for (int i = 0;i < board.length; i++) {
                String s = "";
                for (int j = 0;j < board[0].length; j++) {
                    if (board[i][j] == 'Q') s += "Q";
                    else s += ".";
                }
                curRes.add(s);
            }
            return curRes;
        }
    }


}
