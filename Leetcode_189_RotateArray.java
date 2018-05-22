package com.company;

public class Leetcode_189_RotateArray {
    /*
method 1:
    reverse total array
    reverse first part
    reverse last part
    Time Complexity: O(n)
    Space Complexity: O(1)
    */
    class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums,0, nums.length-1);
            reverse(nums,0, k-1);
            reverse(nums,k, nums.length-1);
        }

        public void reverse(int[] nums, int left, int right){
            while(left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;

                left++;
                right--;
            }

            return;
        }
    }



}
