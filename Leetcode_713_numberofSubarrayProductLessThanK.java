package com.company;

public class Leetcode_713_numberofSubarrayProductLessThanK{
    class Solution {
        /*
        1.The idea is always keep an max-product-window less than K;
        2.Every time shift window by adding a new number on the right(j), if the product is greater than k, then try to reduce numbers     on the left(i), until the subarray product fit less than k again, (subarray could be empty);
        3.Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
    example:
    for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))
            (6)
         (2, 6)
      (5, 2, 6)
        */
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int res = 0;
            int pro = 1;

            for(int i = 0, j = 0;j < nums.length;j++){
                pro *= nums[j];

                while(i <= j && pro >= k){
                    pro /= nums[i];
                    i++;
                }

                res += j - i + 1;
            }

            return res;
        }
    }
}
