package com.company;

public class Leetcode_673_NumberOfLongestIncreaseSequence {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int leng = nums.length;
            int[] len = new int[leng];
            int[] counts = new int[leng];
            int res = 0;
            int max_len = 0;
            for(int i = 0; i < leng; i++) {
                len[i] = 1;
                counts[i] = 1;
                for(int j = 0; j <i ; j++) {
                    if(nums[i] > nums[j]) {
                        if(len[i] == len[j] + 1) counts[i] += counts[j];
                        if(len[i] < len[j] + 1){
                            len[i] = len[j] + 1;
                            counts[i] = counts[j];
                        }
                    }
                }

                if(max_len == len[i]) res += counts[i];
                if(max_len < len[i]){
                    max_len = len[i];
                    res = counts[i];
                }
            }

            return res;
        }
    }
}
