package com.company;

import java.util.Arrays;

public class Leetcode_300_LongestIncreasingSubsequence {
    /*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums){
            int i = Arrays.binarySearch(dp,0,len,x);
            if(i < 0) i = -(i+1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
*/
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int n = nums.length;

            int[] dp = new int[n]; // dp[i] = length of LIS ends with nums[i] (nums[i] must be used)
            Arrays.fill(dp, 1);

            int max = 0;
            for (int i = 0;i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }
}
