package com.company;

public class Leetcode_055_JumpGame{
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            if(n == 1) return true;

            int last = n - 1;

            for(int i = n-2;i >= 0;i--){
                if(nums[i]+i >= last) last = i;
            }

            return last <= 0;
        }
    }
}
