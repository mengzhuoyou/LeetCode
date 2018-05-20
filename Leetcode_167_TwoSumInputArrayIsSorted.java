package com.company;

public class Leetcode_167_TwoSumInputArrayIsSorted{
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
        /*We can set two pointers, left and right,
        if the sum of these two pointers are larger than target, then we move the right pointer left;
        if the sum of these two pointers are smaller than target, then we move the left pointer right;
        */

            int left = 0, right = numbers.length-1;
            while(left < right){//since we can just use the element once, there is no =;
                if(numbers[left]+numbers[right] > target){
                    right--;
                } else if(numbers[left]+numbers[right] < target){
                    left++;
                }    else
                    return new int[] {left+1, right+1};
            }

            return new int[] {0,0};
        }
    }
}
