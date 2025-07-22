package Coding360.DP;

/*
Problem statement
You are given an integer ‘N’ denoting the length of the rod. You need to determine the maximum number of segments you can make of this rod provided that each segment should be of the length 'X', 'Y', or 'Z'.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
2
7 5 2 2
8 3 3 3
Sample Output 1:
2
0
Explanation For Sample Input 1:

In the first test case, cut it into 2 parts of 5 and 2.

In the second case, there is no way to cut into segments of 3 length only as the length of the rod is less than the given length.
Sample Input 2:
2
7 3 2 2
8 1 4 4
Sample Output 2:
3
8
Explanation For Sample Input 2:
In the first test case, cut it into 3 parts of 3, 2 and 2.

In the second case, cut it into 8 parts of length 1.
 */

import java.util.Arrays;

public class CutInSegments {
    public static void main(String[] args) {

    }

    public static int cutSegments(int n, int x, int y, int z) {
//        int res =  cutSegmentsRecursively(n, x, y, z);
//        return cutSegmentsTabulation(n, x, y, z);

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        int res = cutSegmentsMemoization(n, x, y, z, memo);
        return res < 0 ? 0: res;
    }

    private static int cutSegmentsMemoization(int n, int x, int y, int z, int[] memo) {
        if(x==1 || y==1 || z==1){
            return n;
        }

        if(n == 0){
            return 0;
        }

        if(n < 0){
            return Integer.MIN_VALUE;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        int cutX = cutSegmentsMemoization(n-x, x, y, z, memo) +1;
        int cutY = cutSegmentsMemoization(n-y, x, y, z, memo) +1;
        int cutZ = cutSegmentsMemoization(n-z, x, y, z, memo) +1;

        memo[n] = Math.max(cutX, Math.max(cutY, cutZ));

        return memo[n];
    }

//    Tabulation
    public static int cutSegmentsTabulation(int n, int x, int y, int z){
        int []dp = new int [n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);

        dp[0] =0;

        for (int i =1; i <=n ; i++)
        {
            if( i >=x && dp[i-x]!=Integer.MIN_VALUE)
            {
                dp[i] = Math.max(dp[i], dp[i-x] +1);
            }
            if( i >=y && dp[i-y]!=Integer.MIN_VALUE)
            {
                dp[i] = Math.max(dp[i], dp[i-y] +1);
            }
            if( i >=z && dp[i-z]!=Integer.MIN_VALUE)
            {
                dp[i] = Math.max(dp[i], dp[i-z] +1);
            }
        }
        return dp[n] <0 ? 0 : dp[n];
    }


    private static int cutSegmentsRecursively(int n, int x, int y, int z) {
        if(x==1 || y==1 || z==1){
            return n;
        }

        int maxCount = Integer.MIN_VALUE;

        int cutX = cutSegmentsRecursively(n-x, x, y, z);
        int cutY = cutSegmentsRecursively(n-y, x, y, z);
        int cutZ = cutSegmentsRecursively(n-z, x, y, z);

        maxCount = Math.max(cutX, Math.max(cutY, cutZ));

        return maxCount;
    }
}
