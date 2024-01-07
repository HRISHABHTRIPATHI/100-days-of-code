
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

    public static boolean solve(int[] arr, int target, int idx, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || idx == arr.length && target != 0) {
            return false;
        }
        if (dp[idx][target] != null) {
            return dp[idx][target];
        }
        boolean pick = solve(arr, target - arr[idx], idx + 1, dp);
        boolean notpick = solve(arr, target, idx + 1, dp);
        return dp[idx][target] = pick || notpick;
    }

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        Boolean[][] dp = new Boolean[N + 1][sum + 1];
        return solve(arr, sum, 0, dp);
    }
}