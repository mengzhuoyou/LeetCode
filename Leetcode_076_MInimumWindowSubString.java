package com.company;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_MInimumWindowSubString {
    class Solution {
        /*
            we will use tow pointers, left and right, advance right first to find the required window, and then advance left pointer to find the minimum window;
            Time Complexity: O(n);
        */
        public String minWindow(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();

            for(char c : t.toCharArray()){
                if(map.containsKey(c)) map.put(c, map.get(c)+1);
                else map.put(c,1);
            }

            int left = 0;             //current left index
            int minLeft = 0;          //the final answer's window's left index
            int minLen = s.length()+1;//the final answer's window's length
            int count = 0;            //how many required characters we have found

            for(int right = 0;right < s.length(); right++){
                if(map.containsKey(s.charAt(right))){
                    map.put(s.charAt(right), map.get(s.charAt(right))-1);
                    if(map.get(s.charAt(right)) >= 0) count++;

                    while(count == t.length()){//current window satisfy constraints
                        if(right-left+1 < minLen){
                            minLeft = left;
                            minLen = right-left+1;
                        }

                        if(map.containsKey(s.charAt(left))){
                            map.put(s.charAt(left), map.get(s.charAt(left))+1);
                            if(map.get(s.charAt(left)) > 0) count--;
                        }

                        left++;
                    }
                }
            }

            if(minLen == s.length()+1) return "";
            return s.substring(minLeft, minLeft+minLen);
        }
    }
}
