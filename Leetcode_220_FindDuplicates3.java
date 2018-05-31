package com.company;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_220_FindDuplicates3 {
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if(k < 0 || t < 0 || (k == 0 && t != 0)) return false;
            int w = t + 1;
            Map<Integer,Integer> map = new HashMap<>();

            for(int i = 0;i < nums.length;i++){
                int id = nums[i]<0 ? (nums[i])/w - 1 : (nums[i]/w);

                if(map.containsKey(id)) return true;

                if(map.containsKey(id-1) && Math.abs(map.get(id-1)-nums[i])<w ) return true;

                if(map.containsKey(id+1) && Math.abs(map.get(id+1)-nums[i])<w ) return true;

                map.put(id, nums[i]);

                if(i >= k) {
                    int preid = nums[i-k]<0 ? (nums[i-k])/w - 1 : (nums[i-k]/w);
                    map.remove(preid);
                }
            }

            return false;
        }
    }
}
