package com.company;

public class Leetcode_137_SingleNumber2 {
    class Solution {
        /*
            This question has two implementations, but both are the same approach. List how many 1s at each set, because every number occurs 3 times except 1 number just once, so those bits whose numbers cannot be divided by 3, has that number.
            ex: 2 3 2 2 4 4 4
         0   1     0
         0   1     1
         0   1     0
         0   1     0
         1   0     0
         1   0     0
         1   0     0
        -------------add up
        3(1) 4(1)  1(1)

        so: it should be 011, which is 3;

            Method1:
            int res = 0;
            for(int i = 0;i < 32;i++){
                int sum = 0; //count at current bit, how many 1s appeared;
                for(int num : nums){
                    if( (( num>>i )&1) == 1) sum++;
                }

                if( (sum%3) != 0) res = res | (1<<i);
            }
            return res;

            Time Complexity: O(32*n)
            Space Complexity: O(1)
        */
        public int singleNumber(int[] nums) {
        /*
        Method2:
        Time Complexity: O(n)
        Space Complexity: O(1)

        We can know that, the state transition is : 00 -> 01 -> 10, once it arrives 10, it will automatically go back to 00
        so for the high bit: 0 -> 0 -> 1, and then back to 0
            therefore, its formula should be :
                high = high ^ num (XOR)
                if(low == 1) high = 0;
            combine result: high = (high^num) & ~low

        so for the low bit: 0 -> 1 -> 0, and then back to 0
            therefore, its formula should be :
                low = low ^ num (XOR)
                if(high == 1) high = 0;
            combine result: low = (low^num) & ~high
        */

            int ones = 0;
            int twos = 0;
            for(int num : nums){
                ones = (ones^num) & ~twos;
                twos = (twos^num) & ~ones;
            }

            return ones;//why return ones? you can just think the case, there is only onr number, ones is the first given value
        }
    }
}
