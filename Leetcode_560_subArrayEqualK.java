package com.company;

import java.util.*;

public class Leetcode_560_subArrayEqualK {
    /**
     the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap. Time complexity O(n);
     Space complexity O(n).
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int sum = 0, res = 0;
            Map<Integer, Integer> presum = new HashMap<>();

            presum.put(0,1);

            for(int num : nums){
                sum += num;
                res += presum.getOrDefault(sum - k, 0);
                presum.put(sum, presum.getOrDefault(sum, 0)+1);
            }

            return res;
        }
    }
}
