//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++)
                coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public long count(int arr[], int n, int T) {
        // code here.
        long dp[][] = new long[n][T + 1];
        // Initialize base condition for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled, as dp array is initialized to zero
        }
        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                long notTaken = dp[ind - 1][target];
                long taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];
                dp[ind][target] = notTaken + taken;
            }
        }
        return dp[n - 1][T];
    }
}