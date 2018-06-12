package com.company;

import java.util.*;

public class Leetcode_030_SubstringWithConcatenationofWords {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if(words == null || words.length == 0) return res;

            Map<String, Integer> map = new HashMap<>();
            for(int i = 0;i < words.length;i++)
                if(map.containsKey(words[i]))
                    map.put(words[i], map.get(words[i])+1);
                else
                    map.put(words[i], 1);

            int num = words.length, len = words[0].length(), s_len = s.length();
            for(int i = 0; i < s_len-num*len+1; i++) {
                int count = 0;
                int start = i;
                Map<String, Integer> map2 = new HashMap<>();
                boolean flag = true;
                while(count < num){
                    String cur = s.substring(i+count*len,i+count*len+len);
                    if(map.containsKey(cur)) {
                        count++;
                        if(!map2.containsKey(cur))
                            map2.put(cur,1);
                        else if(map2.get(cur) < map.get(cur))
                            map2.put(cur, map2.get(cur)+1);
                        else {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }
                }

                if(count == num && flag) res.add(i);
            }

            return res;
        }
    }
}
