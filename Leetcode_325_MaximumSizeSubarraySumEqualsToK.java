package com.company;

import java.util.HashMap;

public class Leetcode_325_MaximumSizeSubarraySumEqualsToK {
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
        /*
            For this problem, we can know that the subarray of the final answer must be nums[i,j] = k,
            and sum[i,j] = sum[0,j] - sum[0,i], so we can define a variable:sum that is equal to sum of all the elements before index i,
            and in order to look up the sum value quickly, we can store them in a hashmap;

            so the hashmap map(key,value): key is the sum of all the elements before index i, value is the index i;
        */

            int sum = 0;
            int maxLen = 0;
            HashMap<Integer,Integer> map = new HashMap<>();

            for(int i = 0; i < nums.length;i++){
                sum += nums[i];

                if(sum == k) maxLen = i+1; //if here sum == k, the length must be the max length so far;
                else if(map.containsKey(sum-k)) maxLen = Math.max(maxLen, i-map.get(sum-k));

                if(!map.containsKey(sum)) map.put(sum,i);//here, for the same sum, we may have several sub arrays, we choose the most left one, so that the i-get(sum-k) can be the longest;
            }

            return maxLen;
        }
    }
}
