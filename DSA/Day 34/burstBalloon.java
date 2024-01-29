//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxCoins(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int maxCoins(int N, int[] a) {
        // code here
        int arr[] = new int[N + 2];
        arr[0] = arr[N + 1] = 1; // append 1 at both ends

        // copying Array
        for (int i = 1; i <= N; i++) {
            arr[i] = a[i - 1];
        }

        int dp[][] = new int[N + 2][N + 2];

        for (int i = N; i >= 1; i--) {
            for (int j = i; j <= N; j++) {

                int ans = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {
                    int coins = arr[i - 1] * arr[k] * arr[j + 1]
                            + dp[i][k - 1] + dp[k + 1][j];

                    ans = Math.max(ans, coins);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][N];

    }
}
