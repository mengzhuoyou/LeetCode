package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_017_letterCombinationOfPhoneNumbers {
    class Solution {
        public List<String> letterCombinations(String digits) {
            String[] map = new String[] {"0", "1", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            Queue<String> res = new LinkedList<>();
            if (digits.isEmpty()) return (List) res;

            res.offer("");
            for (int i = 0;i < digits.length(); i++) {
                int idx = digits.charAt(i) - '0';
                String cur = map[idx];

                while (res.peek().length() == i) {
                    String top = res.poll();
                    for (char c : cur.toCharArray())
                        res.offer(top+c);
                }
            }

            return (List) res;
        }
    }
}
