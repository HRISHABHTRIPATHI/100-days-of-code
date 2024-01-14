
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG {

    public static void main(String[] args) throws IOException {

        // reading input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // reading total testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            // reading number of eggs and floors
            String inputLine[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);

            // calling eggDrop() method of class
            // EggDrop
            System.out.println(new Solution().eggDrop(n, k));
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int f(int n, int k, int dp[][]) {
        if (k == 0 || k == 1)
            return k;
        if (n == 1)
            return k;
        if (dp[n][k] != -1)
            return dp[n][k];
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            int breaks = f(n - 1, j - 1, dp);
            int doesNotBreak = f(n, k - j, dp);
            int maxDrops = 1 + Math.max(breaks, doesNotBreak);
            min = Math.min(min, maxDrops);
        }
        return dp[n][k] = min;
    }

    // Function to find minimum number of attempts needed in
    // order to find the critical floor.
    static int eggDrop(int egg, int floor) {
        // Your code here
        int dp[][] = new int[egg + 1][floor + 1];
        // Initialize the dp array
        for (int i = 0; i <= egg; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(egg, floor, dp);
    }
}