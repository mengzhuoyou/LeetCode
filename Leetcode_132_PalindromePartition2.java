package com.company;

public class Leetcode_132_PalindromePartition2 {
    /*
    for this question, we can use dp method.
    denote f[i] is the minimum cut for s.substring(0,i+1)
    so the final result we want to get is : f[len-1] --> s.substring(0,len)
    f[right] = f[left-1] + 1;
    Time: O(n^2)
    Space: O(n)
*/

    class Solution {
        public int minCut(String s) {
            int len = s.length();
            int[] f = new int[len];

            for(int i = 0;i < len;i++) f[i] = i;//suppose each character is different, so it needs i cut; that is the maximum one.

            for(int i = 0;i < len;i++){//expand from center
                search(s,f,i,i); // odd
                search(s,f,i,i+1); // even
            }

            return f[len-1];
        }

        public void search(String s, int[] f, int left, int right){
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                if(left == 0)
                {
                    f[right] = 0;//do not need cut;
                }
                else
                {
                    f[right] = Math.min(f[right], f[left-1]+1);
                }
                left--;
                right++;
            }
        }
    }
}
