package com.company;

public class Leetcode_120_minimumPathInTriangle{
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
        /*
        Time Complexity: O(mn);
        Space Complexity: O(mn);
        *********************************
        int res = Integer.MAX_VALUE;

        int m = triangle.size();
        int n = m;
        int[][] dp = new int[m][n];

        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1;i < m;i++)
            for(int j = 0;j < triangle.get(i).size();j++){
                int pre;
                if(j == 0) pre = dp[i-1][j];
                    else if(j == triangle.get(i).size()-1) pre = dp[i-1][j-1];
                        else pre = Math.min(dp[i-1][j-1],dp[i-1][j]);

                dp[i][j] = pre + triangle.get(i).get(j);

            }

    for(int i = 0;i < n;i++)
        if(res > dp[m-1][i]) res = dp[m-1][i];

    return res;
    */
    /*
        For this problem, in order to avoid overwrite the previous row's value, we need to do this from bottom to top, not top to bottom;
        So, the first iteration is to initialize the A array;

    */

            int[] res = new int[triangle.size()+1];

            for(int i = triangle.size()-1; i >= 0;i--)
                for(int j = 0; j < triangle.get(i).size(); j++){
                    res[j] = Math.min(res[j],res[j+1]) + triangle.get(i).get(j);
                }

            return res[0];
        }
    }
}
