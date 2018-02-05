package com.company;
/*
    Solution 1:
    Time Complexity: O(n);
    Constant Space;
    Method: Visual Index;
    In this method, left indicates index: 1 3 5
                    right indicates index: 4 2 0

    Solution 2:
    Time Conplexity: O(nlogn);
    Space Complexity: O(n);
    Method:
    copy a new array;
    Arrays.sort();
    Find median;
    odd position put nums[mid--];
    even position put nums[end--];

    */
public class LeetCode_324_WiggleSort_2 {
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

        int newIndex(int i, int n){
            return ((1 + 2*i) % (n | 1));
        }

        public void wiggleSort(int[] nums) {
            int n = nums.length;
            int median_index = quickSelect(nums,0,n-1,(n+1)/2);
            int median = nums[median_index];

            int left = 0, i = 0, right = n - 1;

            while (i <= right) {

                if (nums[newIndex(i,n)] > median) {
                    swap(nums,newIndex(i,n), newIndex(left,n));
                    i++;
                    left++;
                }else if(nums[newIndex(i,n)] < median){
                    swap(nums,newIndex(i,n),newIndex(right,n));
                    right--;
                }else{
                    i++;
                }
            }

        }

}
