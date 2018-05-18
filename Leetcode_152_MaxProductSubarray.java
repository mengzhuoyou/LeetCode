package com.company;

public class Leetcode_152_MaxProductSubarray{
    class Solution {
        public int maxProduct(int[] nums) {
            int maxhere, minhere;
            int maxsofar = nums[0];
            int maxherepre = nums[0];
            int minherepre = nums[0];

            //maxhere: stores the max product subarray that ends with the current number nums[i];

            for(int i = 1;i < nums.length;i++){
                maxhere = Math.max(nums[i], Math.max(nums[i]*maxherepre, nums[i]*minherepre));
                minhere = Math.min(nums[i], Math.min(nums[i]*maxherepre, nums[i]*minherepre));
                maxherepre = maxhere;
                minherepre = minhere;
                maxsofar = Math.max(maxsofar,maxhere);
            }

            return maxsofar;
        }
    }
}
