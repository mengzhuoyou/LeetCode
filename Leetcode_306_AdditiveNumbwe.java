package com.company;

public class Leetcode_306_AdditiveNumbwe {
    class Solution {
        public boolean isAdditiveNumber(String num) {
            if(num.length() < 3) return false;

            for(int i = 1; i <= num.length()/2; i++) { // i: length of first number
                if(num.charAt(0) == '0' && i > 1) return false;
                Long first = Long.valueOf(num.substring(0, i));

                for(int j = 1; num.length() - i - j >= Math.max(i,j); j++) { // j: length of second number
                    if(num.charAt(i) == '0' && j > 1) break; // try the next length of i
                    Long second = Long.valueOf(num.substring(i, i+j));

                    if(isValid(first, second, i+j, num)) return true;
                }
            }

            return false;
        }

        public boolean isValid(Long first, Long second, int start, String num) {
            if(start == num.length()) return true;

            second = second + first; // now is the sum of previous second + sum
            first = second - first; // now is the previous second

            String sum = second.toString();

            return num.startsWith(sum, start) && isValid(first, second, start + sum.length(), num);
        }
    }
}
