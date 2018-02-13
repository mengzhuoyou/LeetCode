package com.company;

public class Leetcode_169_MajorityElemetn {
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0, res = 0;

            for(int n : nums){
                if(count == 0) res = n;
                if(n != res) count--;
                else count++;
            }

            return res;
        }
    }
}
