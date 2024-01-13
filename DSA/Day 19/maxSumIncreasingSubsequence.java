//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int Arr[] = new int[n];
            for (int i = 0; i < n; i++)
                Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.maxSumIS(Arr, n));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public int maxSumIS(int arr[], int n) {
        // code here.
        int[] dp = new int[n + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i - 1];
            for (int j = i - 1; j > 0; j--) {
                int val = 0;
                if (arr[i - 1] > arr[j - 1])
                    val = arr[i - 1] + dp[j];
                dp[i] = Math.max(dp[i], val);
            }
        }

        for (int x : dp) {
            if (x > max)
                max = x;
        }

        return max;
    }
}