package com.company;

import java.util.Arrays;

public class Leetcode_016_3SumClosest {
    /**
     Use 3 pointers to point current element, next element and the last element. If the sum is less than target, it means we have to add a larger element so next element move to the next. If the sum is greater, it means we have to add a smaller element so last element move to the second last element. Keep doing this until the end. Each time compare the difference between sum and target, if it is less than minimum difference so far, then replace result with it, otherwise keep iterating.
     */

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length;
            int res = nums[0] + nums[1] + nums[n-1];

            Arrays.sort(nums);
            for(int i = 0;i < n - 2;i++){
                int start = i+1, end = n - 1;
                while(start < end){
                    int tmp = nums[i] + nums[start] + nums[end];
                    if(tmp > target){
                        end--;
                    } else if(tmp < target){
                        start++;
                    } else return target;

                    if(Math.abs(tmp - target) < Math.abs(res - target)) res = tmp;
                }
            }

            return res;
        }
    }
}
