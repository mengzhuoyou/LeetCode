package com.company;

public class Leetcode_079_WordSearch{
    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] w = word.toCharArray();
            for(int i = 0;i < board.length;i++){
                for(int j = 0;j < board[0].length;j++){
                    if(exist(board,i,j,w,0)) return true;
                }
            }

            return false;
        }

        boolean exist(char[][] board, int x, int y, char[] w,int i){
            if(i == w.length) return true;

            if(x < 0 || x == board.length || y < 0 || y == board[0].length || board[x][y] != w[i]) return false;

            board[x][y] ^= 256;
            boolean flag = exist(board,x-1,y,w,i+1) || exist(board,x,y-1,w,i+1) || exist(board,x+1,y,w,i+1) ||                   exist(board,x,y+1,w,i+1);
            board[x][y] ^= 256;
            return flag;
        }
    }
}
