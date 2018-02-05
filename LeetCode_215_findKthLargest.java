package com.company;
<<<<<<< HEAD

class findKthLargest{
=======
  /*
  Time Complexity: O(n);
  Constant Space;
  */
   class Solution {
>>>>>>> 6f3fd430dc5369b3bfc7f861b2d4aef624c87bfa
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int index = quickSelect(nums,0,n-1 , n - k + 1);
        return nums[index];
    }

    public int quickSelect(int[] a, int lo, int hi, int k) {
        int i = lo, j = hi, pivot = a[hi];
        while (i < j) {
            if (a[i] > pivot) {
                swap(a, i, --j);
            }else i++;

        }
        swap(a, i, hi);

        int m = i - lo + 1;

        if(m == k) return i;
        else if(m > k) return quickSelect(a,lo,i-1,k);
        else return quickSelect(a,i+1,hi,k-m);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
