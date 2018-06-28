package com.company;

import java.util.Stack;

public class Leetcode_402_removeKdigits {
    /*
public class Solution {
    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }
}
*/

    class Solution {
        public String removeKdigits(String num, int k) {
            int digits = num.length() - k;
            Stack<Character> stack = new Stack<>();

            for(int i = 0;i < num.length();i++) {
                char c = num.charAt(i);
                while(!stack.isEmpty() && stack.peek() > c && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
            }

            StringBuilder sb = new StringBuilder("");
            while(!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }

            String res = sb.toString();

            int idx = 0;
            while(idx < digits && res.charAt(idx) == '0')
                idx++;

            return idx == digits ? "0" : res.substring(idx, res.length()-k);

        }
    }
}
