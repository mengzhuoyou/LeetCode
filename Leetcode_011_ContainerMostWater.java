package com.company;

public class Leetcode_011_ContainerMostWater{
    /*
      1 2 3 4 5 6
    1 x ------- o
    2 x x - o o o
    3 x x x o | |
    4 x x x x | |
    5 x x x x x |
    6 x x x x x x
     */
    public int maxArea(int[] height) {
        if(height == null || height.length == 1) return 0;
        int left = 0, right = height.length-1;
        int max = 0;

        while(left < right){
            int curLeft = height[left], curRight = height[right];
            max = Math.max(max, (right-left)*Math.min(curLeft,curRight));
            if(curLeft < curRight) left++;
            else right--;
        }

        return max;
    }
}

