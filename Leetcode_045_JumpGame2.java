package com.company;

public class Leetcode_045_JumpGame2 {
    class Solution {
        public int jump(int[] nums) {
            int step = 0;
            int curEnd = 0, curFarthest = 0;

            for(int i = 0;i < nums.length - 1;i++){
                curFarthest = Math.max(curFarthest, i+nums[i]);
                if(i == curEnd){
                    step++;
                    curEnd = curFarthest;
                }
            }

            return step;
        }
    }
}