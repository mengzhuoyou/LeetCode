package com.company;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_421_MaximumXORofTwoNumbersinanArray {
    class Solution {
        public int findMaximumXOR(int[] nums) {
            int max = 0, mask = 0;

            for (int i = 31; i >= 0;i--) {
                mask |= (1 << i);

                // get all the i bits
                Set<Integer> hash = new HashSet<>();
                for (int num : nums) {
                    hash.add((num & mask));
                }

                //
                int tmp = max | (1 << i);
                for (int h : hash) {
                    if (hash.contains(h ^ tmp)) {
                        max = tmp;
                        break;
                    }
                }

            }

            return max;
        }
    }
}
