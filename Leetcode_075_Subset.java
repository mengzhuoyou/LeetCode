package com.company;

import java.util.*;

public class Leetcode_075_Subset{
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(list, new ArrayList<>(), nums, 0);
            return list;
        }

        private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
            list.add(new ArrayList<>(tempList));
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

/* Method1
            The idea is:
            起始subset集为：[]
            添加S0后为：[], [S0]
            添加S1后为：[], [S0], [S1], [S0, S1]
            添加S2后为：[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2], [S0, S1, S2]

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int num : nums){
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> cur : res){
                List<Integer> curr = new ArrayList<>(cur);
                curr.add(num);
                tmp.add(curr);
            }
            res.addAll(tmp);
        }

        return res;*/

/*
        Method2: Bit Manipulation
        000 : {}
        001 : {1}
        101 : {1,3}

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for(int i = 0;i < power(n); i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0;j < 32;j++){
                if(((i>>j)&1)==1) tmp.add(nums[j]);
            }
            res.add(tmp);
        }

        return res;
    }

    int power(int n){
        int res = 1;
        while(n > 0){
            res *= 2;
            n--;
        }
        return res;
        */
}
