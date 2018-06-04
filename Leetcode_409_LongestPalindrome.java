package com.company;

public class Leetcode_409_LongestPalindrome {
    class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[128];//store each letter's occurrence times
            int ans = 0;

            for(char c : s.toCharArray()){
                count[c]++;
            }

            boolean is_odd = false;

            for(int num : count){
                if(num % 2 == 0)
                    ans += num;
                else if(num > 2){
                    ans += (num / 2)*2;
                    is_odd = true;
                } else{//num = 1
                    is_odd = true;
                }
            }

            return is_odd ? ans+1 : ans;
        }
    }
}
