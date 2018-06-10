package com.company;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_060_PermutationsSequences {
    class Solution {
        public String getPermutation(int n, int k) {
            int[] factorials = new int[n+1];
            int factorial = 1;
            List<Integer> nums = new ArrayList<>();

            for(int i = 1;i <= n;i++){
                factorial *= i;
                factorials[i] = factorial;
                nums.add(i);
            }

        /*
                 index: 0   1   2   3
            factorials: 0   1   2   6
                  nums: 1   2   3
        */

            StringBuilder sb = new StringBuilder();
            k--;

            while(nums.size() > 0){
                int curBranch = factorials[nums.size()]/nums.size();// =2
                int index = k / curBranch;// index = 3 / 2 = 1;
                sb.append(nums.get(index));
                nums.remove(index);

                k = k % curBranch;
            }

            return sb.toString();
        }
    }


/*
    {1,2,3,4}:
        1+{2,3,4}:
            2+{3,4}:
                3+{4}:  1234
                4+{3}:  1243
            3+{2,4}:
                2+{4}:  1324
                4+{2}:  1342
            4+{2,3}:
                2+{3}:  1423
                3+{2}:  1432
        2+{1,3,4}:
        3+{1,2,4}:
        4+{1,2,3}:

        perm[1] = 1
        perm[2] = 2
        perm[3] = 6
*/
}
