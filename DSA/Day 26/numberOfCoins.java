//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++)
                coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends

class Solution {

    public int minCoins(int coins[], int M, int V) {
        // Your code goes here
        int[][] dp = new int[M + 1][V + 1];
        for (int i = 0; i <= V; i++)
            dp[0][i] = Integer.MAX_VALUE - 1;

        for (int i = 1; i <= M; i++)
            dp[i][0] = 0;

        for (int j = 1; j <= V; j++) {
            if (j % coins[0] == 0)
                dp[1][j] = j / coins[0];
            else
                dp[1][j] = Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i <= M; i++)
            for (int j = 1; j <= V; j++) { // run from 2nd row
                if (coins[i - 1] <= j)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                else
                    dp[i][j] = dp[i - 1][j];
            }

        return dp[M][V] == Integer.MAX_VALUE - 1 ? -1 : dp[M][V];
    }
}