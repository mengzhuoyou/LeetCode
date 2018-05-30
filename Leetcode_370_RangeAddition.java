package com.company;

public class Leetcode_370_RangeAddition {
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] res = new int[length];

            for(int i = 0;i < updates.length;i++){
                int inc = updates[i][2];
                int start = updates[i][0];
                int end = updates[i][1];

                res[start] += inc;

                if(end < length-1)
                    res[end+1] -= inc;
            }

            int sum = 0;
            for(int i = 0;i < res.length;i++){
                sum += res[i];
                res[i] = sum;
            }
            return res;
        }
    }
}
