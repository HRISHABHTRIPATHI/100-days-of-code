//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    // static int f(int arr[], int i, int j, int[][] dp){
    // // base condition
    // if(i == j)
    // return 0;
    // if(dp[i][j]!=-1)
    // return dp[i][j];
    // int mini = Integer.MAX_VALUE;
    // // partioning loop
    // for(int k = i; k<= j-1; k++){
    // int ans = f(arr,i,k,dp) + f(arr, k+1,j,dp) + arr[i-1]*arr[k]*arr[j];
    // mini = Math.min(mini,ans);
    // }
    // return mini;
    // }
    static int mcmMemo(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmMemo(arr, i, k, dp);
            int cost2 = mcmMemo(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }
        return dp[i][j] = ans;
    }

    static int matrixMultiplication(int N, int arr[]) {
        // code here
        // int dp[][]= new int[N][N];
        // for(int row[]:dp)
        // Arrays.fill(row,-1);
        // int i =1;
        // int j = N-1;
        // return f(arr,i,j,dp);

        int dp[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        return mcmMemo(arr, 1, N - 1, dp);
    }
}