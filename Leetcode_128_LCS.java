package com.company;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_128_LCS {
    class Solution {
        /**
         Time Complexity : O(n);
         Space Complexity : O(n); For the HashSet to store the nums, so that can look up value in O(1);
         */
        public int longestConsecutive(int[] nums) {
            Set<Integer> nums_set = new HashSet<>();
            int res = 0;

            for(int num : nums) nums_set.add(num);

            for(int num : nums){
                if(!nums_set.contains(num - 1)){
                    int cur = 1;
                    int cur_num = num;

                    while(nums_set.contains(cur_num + 1)){
                        cur++;
                        cur_num++;
                    }

                    if(cur > res) res = cur;
                }
            }

            return res;
        }
    }
}
