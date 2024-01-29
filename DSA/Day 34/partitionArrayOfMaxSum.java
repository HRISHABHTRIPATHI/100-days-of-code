//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.solve(N, k, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public int solve(int N, int k, int arr[]) {
        // Code here
        int dp[] = new int[N + 1];

        for (int i = N - 1; i >= 0; i--) {

            int len = 0;
            int max = Integer.MIN_VALUE;
            int ans = Integer.MIN_VALUE;

            for (int j = i; j < Math.min(N, i + k); j++) {

                len++;
                max = Math.max(max, arr[j]);
                int sum = len * max + dp[j + 1];
                ans = Math.max(ans, sum);
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}