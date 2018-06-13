package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_047_permutations2 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            backtrack(res, new ArrayList<>(), nums, used);
            return res;
        }

        public void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] used) {
            if(cur.size() == nums.length) {
                res.add(new ArrayList<Integer>(cur));
                return;
            }

            for(int i = 0;i < nums.length;i++) {
                if(used[i]) continue;
                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                cur.add(nums[i]);
                used[i] = true;
                backtrack(res, cur, nums, used);
                cur.remove(cur.size()-1);
                used[i] = false;
            }
        }
    }
}
