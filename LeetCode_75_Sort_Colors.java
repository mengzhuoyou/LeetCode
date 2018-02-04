package com.company;

/*
    Time Complexity : O(n)
    Space Complexity: Constant Space


    We will do one pass: put all the 0 to left, put all the 2 to right, so all the 1 can be in the middle.
    Note: if(nums[index] == 2), after swap, we need to review position index, so we need to index--;
*/
class LeetCode_75_Sort_Colors {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        int index = 0;

        while(index <= p2){
            if(nums[index] == 0){
                nums[index] = nums[p0];
                nums[p0] = 0;
                p0++;
            }
            if(nums[index] == 2){
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }

    }
}