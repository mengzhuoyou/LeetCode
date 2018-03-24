package com.company;

public class Leetcode_035_FindInsertPosition{
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0, r = nums.length;

            while(l < r){
                int mid = l + (r - l)/2; // low <= mid < high
                if(nums[mid] > target) r = mid;
                else if(nums[mid] < target) l = mid + 1;
                else return mid;
            }

            return l;//the only case it break the while loop is : l == r and nums[l] > target
        }
    }
}
