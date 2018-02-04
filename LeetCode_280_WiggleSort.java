/*
   Iterate the arrays once, each time we compare arr[i] with arr[i-1] to determine whether we swap the adjcent numbers.

   Time Complexity: O(n)

*/
class Solution {
    public void wiggleSort(int[] nums) {
       /* 3 5 2 1 6 4
          3 5 1 2 6 4*/

        for(int i = 0;i < nums.length;i++){
            if(i % 2 == 1){
                if(nums[i-1] > nums[i]) swap(nums,i);
            } else if(i % 2 == 0 && i != 0){
                if(nums[i-1] < nums[i]) swap(nums,i);
            }

        }

    }

    public void swap(int[] nums,int idx){
        int tmp = nums[idx];
        nums[idx] = nums[idx-1];
        nums[idx-1] = tmp;
    }
}