package com.company;

import java.util.Arrays;

public class Leetcode_318_MaximumProductOfWordLength {
    public class Solution {
        public int maxProduct(String[] words) {
            if (words == null || words.length <= 1) {
                return 0;
            }

            int[] value = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                String tmp = words[i];
                value[i] = 0;
                for (int j = 0; j < tmp.length(); j++) {
                    value[i] |= 1 << (tmp.charAt(j) - 'a');
                }
            }

            int res = -1;
            for (int out = 0; out < words.length - 1; out++) {
                for (int in = out + 1; in < words.length; in++) {
                    // if (hasSameChar(words[in], words[out])) {
                    if ((value[in] & value[out]) != 0)
                        continue;
                    else {
                        res = Math.max(res, words[out].length() * words[in].length());
                    }
                }
            }
        return res;
    }
}
}
