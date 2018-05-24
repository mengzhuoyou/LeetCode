package com.company;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_216_CombinationSum3 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, new ArrayList<>(), k, n, 1);
            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> tmp, int k, int rest, int start){
            if(tmp.size() == k && rest == 0){
                List<Integer> li = new ArrayList<>(tmp);
                res.add(li);
                return;
            }

            if(tmp.size() == k) return;

            for(int i = start; i <= 9;i++){
                tmp.add(i);
                helper(res, tmp, k, rest-i, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
