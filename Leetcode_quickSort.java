package com.company;

public class Leetcode_quickSort {
    // this function takes last element as pivot
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low; // index of smaller element

        for (int j = low;j < high;j++) {
            // if current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        // at thie time, j = high - 1,
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i; // the first element larger than pivot
    }

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            // arr[pi] is at the right index now

            // now, recursively sort elements before partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    public void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 6, 9, 7, 6, 8, 10, 24, 13, 5};
        sort(arr, 0, arr.length - 1);

        for (int a : arr) System.out.print(a + " ");
        System.out.println();
    }
}
