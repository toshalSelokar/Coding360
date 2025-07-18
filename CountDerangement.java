package Coding360.DP;

/*
Problem statement
A Derangement is a permutation of ‘N’ elements, such that no element appears in its original position. For example, an instance of derangement of {0, 1, 2, 3} is {2, 3, 1, 0}, because 2 present at index 0 is not at its initial position which is 2 and similarly for other elements of the sequence.

Given a number ‘N’, find the total number of derangements possible of a set of 'N’ elements.

Note:
The answer could be very large, output answer %(10 ^ 9 + 7).
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 100
1 <= N <= 3000

Time limit: 1 sec
Sample Input 1:
2
2
3
Sample Output 1:
1
2
Explanation of Sample Output 1:
In test case 1, For two elements say {0, 1}, there is only one possible derangement {1, 0}. 1 is present at index 0 and not at its actual position, that is, 1. Similarly, 0 is present at index 1 and not at its actual position, that is, 0.

In test case 2, For three elements say {0, 1, 2}, there are two possible derangements {2, 0, 1} and {1, 2, 0}. In both the derangements, no element is present at its actual position.

Sample Input 2:
2
1
4
Sample Output 2:
0
9
Explanation of Sample Output 2:
In test case 1, For the array = {0}, there is no possible derrangements. Hence the answer is 0 (zero).

In test case 2, For the array elements = {0, 1, 2, 3}, total 9 derrangements are possible. One of them is: { 3, 2, 1, 0}.
 */

/*Input
        100
        744
        481
        2252
        275
        580
        309
        1992
        2638
        1382
        2623
        1064
        124
        241
        908
        618
        2496
        2972
        96
        2020
        1044
        2239
        2481
        2774
        1657
        1043
        165
        188
        1786
        1028
        1712
        2206
        1554
        1818
        1606
        1504
        1542
        2984
        1615
        360
        2567
        806
        1509
        1060
        619
        850
        1735
        2521
        2119
        2305
        402
        1599
        833
        481
        2638
        382
        1269
        1059
        2325
        2488
        1924
        404
        592
        2794
        2240
        809
        2397
        2653
        1334
        1663
        2266
        360
        559
        1856
        2191
        2419
        527
        377
        1477
        1744
        2318
        2252
        25
        890
        695
        2261
        1528
        101
        1208
        210
        397
        1037
        1261
        1593
        114
        1500
        138
        2802
        2422
        1513
        2078*/

import java.util.Arrays;

public class CountDerangement {
    public static void main(String[] args) {
        int n = 744;
        System.out.println(countDerangements(n));
    }

    private static final int MOD = 1000000007;
    public static long countDerangements(int n) {
//        return countDerangementsRecursive(n);
        return countDerangementsTabulation(n);

       /* long[] memo = new long[n+1];
        Arrays.fill(memo, -1);

        return countDerangementsMemoization(n, memo);
*/
    }

    private static long countDerangementsMemoization(int n, long[] memo) {
        // Base cases
        if (n == 0) return 1; // For 0 items, there's 1 derangement (empty set)
        if (n == 1) return 0; // No derangement possible for 1 item
        if (n == 2) return 1; // One derangement for 2 items

        // Check if we already computed the value for n
        if (memo[n] != -1) {
            return memo[n];
        }

        // Memoize the result using the recursive formula
        memo[n] = ((n - 1) * (countDerangementsMemoization(n - 1, memo) + countDerangementsMemoization(n - 2, memo))) % MOD;

        return memo[n];
    }


    private static long countDerangementsTabulation(int n) {
        // Base cases
        if (n == 0) return 1; // For 0 items, only 1 derangement (trivial case)
        if (n == 1) return 0; // No derangement possible for 1 item
        if (n == 2) return 1; // For 2 items, only 1 derangement is possible

        long[] dp = new long[n + 1];
        dp[0] = 1;  // Derangement of 0 items is 1 (base case)
        dp[1] = 0;  // Derangement of 1 item is 0 (no derangement possible)
        dp[2] = 1;  // Derangement of 2 items is 1 (one valid derangement)

        // Bottom-up dynamic programming
        for (int i = 3; i <= n; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % MOD;
        }

        return dp[n];
    }


    public static long countDerangementsRecursive(int n){
        if (n ==1){
            return 0;
        }
        if( n ==2){
            return 1;
        }

        return (n-1) * (countDerangementsRecursive(n-2) + countDerangementsRecursive(n-1))%MOD;
    }

}
