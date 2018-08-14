package com.company;

import java.util.*;

public class Leetcode_315_countNumberofSmallerSelf {
    /*
    transform to the frequency array, for i'th number, find how many smaller number have been appeared so far, so we need to get the prefix sum of (i)
    it takes O(lgn), so the total is O(nlgn).
    Binary Indexed Tree.
*/
    class Solution {
        class BinaryIndexedTree {
            int[] BITree;

            void updateBIT (int n, int index, int val) {
                index = index + 1;

                while (index <= n) {
                    BITree[index] += val;
                    index += (index & (-index));
                }
            }

            void constructBIT (int[] arr, int n) {
                BITree = new int[n+1];
                for (int i = 0;i <= n;i++) {
                    BITree[i] = 0;
                }

                for (int i = 0;i < n;i++) {
                    updateBIT(n, i, arr[i]);
                }
            }

            int getSum (int index) {
                int sum = 0;

                while (index > 0) {
                    sum += BITree[index];
                    index -= (index & (-index));
                }

                return sum;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            // reverse array
            int len = nums.length;
            int[] reverse = new int[len];
            for (int i = 0;i < len; i++) {
                reverse[i] = nums[i];
            }

            for (int i = 0; i < len/2; i++) {
                int tmp = reverse[i];
                reverse[i] = reverse[len - 1 - i];
                reverse[len - 1 - i] = tmp;
            }

            // get the indexed array
            Arrays.sort(nums);
            Map<Integer, Integer> map = new HashMap<>();
            int rank = 1;
            for (int i = 0;i < len; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], rank);
                    rank++;
                }
            }

            int[] indexed = new int[len];
            for (int i = 0;i < len;i++) {
                indexed[i] = map.get(reverse[i]);
            }

            // construct BIT
            BinaryIndexedTree tree = new BinaryIndexedTree();
            int[] freq = new int[len];

            List<Integer> res = new ArrayList<>();

            tree.constructBIT(freq, len);

            for (int idx : indexed) {
                res.add(0, tree.getSum(idx));
                tree.updateBIT(len, idx, 1);
            }

            return res;
        }
    }
}
