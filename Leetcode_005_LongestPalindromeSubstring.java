package com.company;

public class Leetcode_005_LongestPalindromeSubstring {
    //method1: reverse S and find the longest common substring,remember to check if it is a valid palindrome
    //method2: dp. p(i,j) = p(i+1,j-1) && (s[i] == s[j]).   O(n^2) time, O(n^2) space(can improve to O(n))
    //method3: expand around center.  O(n^2) time, O(1) space


    //method 3
    class Solution {
        int start = 0;
        int max = 0;
        public String longestPalindrome(String s) {
            for(int i = 0;i < s.length();i++){
                expand(s,i,i);//odd
                expand(s,i,i+1);//even
            }

            return s.substring(start, max+start);
        }

        private void expand(String s, int l,int r){
            int len = 0;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                len = r - l + 1;
                l--;
                r++;
            }

            if(max < len) {
                max = len;
                start = l + 1;
            }

        }
    }
}
