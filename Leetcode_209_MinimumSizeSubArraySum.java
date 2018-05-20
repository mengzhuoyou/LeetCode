package com.company;

public class Leetcode_209_MinimumSizeSubArraySum{
    class Solution {
        /*
        We use two pointers;
        This method is O(n): because j moves n times, and i moves at most n times; So with the increasment of n, the total iterat times increase the same as n, that is at most 2*n;
        */
        public int minSubArrayLen(int s, int[] nums) {
            int sum = 0;
            int i = 0, j = 0;
            int min = Integer.MAX_VALUE;

            while(j < nums.length){
                sum += nums[j++];

                while(sum >= s) {
                    min = Math.min(min, j-i);
                    sum -= nums[i];
                    i++;
                }

            }

            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
}
