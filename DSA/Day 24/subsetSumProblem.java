
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(N, arr, sum))
                System.out.println(1);
            else
                System.out.println(0);

        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {

    // public static boolean solve(int[] arr,int target,int idx,Boolean[][] dp){
    // if(target==0){
    // return true;
    // }
    // if(target<0 || idx==arr.length && target!=0){
    // return false;
    // }
    // if(dp[idx][target]!=null){
    // return dp[idx][target];
    // }
    // boolean pick=solve(arr,target-arr[idx],idx+1,dp);
    // boolean notpick=solve(arr,target,idx+1,dp);
    // return dp[idx][target]=pick||notpick;
    // }

    static Boolean isSubsetSum(int n, int arr[], int k) {
        // Boolean[][] dp=new Boolean[N+1][sum+1];
        // return solve(arr,sum,0,dp);
        boolean dp[][] = new boolean[n][k + 1];
        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }
        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current
                // element
                boolean notTaken = dp[ind - 1][target];
                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }
        // The final result is stored in the bottom-right cell of the DP table
        return dp[n - 1][k];
    }
}