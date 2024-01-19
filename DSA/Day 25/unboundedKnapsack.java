//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for (int i = 0; i < N; i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for (int i = 0; i < N; i++)
                wt[i] = Integer.parseInt(line3[i]);

            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int knapSack(int n, int W, int val[], int wt[]) {
        // code here
        int cur[] = new int[W + 1];

        // Base condition: Initialize the cur array for the first item
        for (int i = wt[0]; i <= W; i++) {
            cur[i] = ((int) i / wt[0]) * val[0];
        }

        // Fill the cur array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = cur[cap];

                // Initialize the maximum value when the current item is taken as the minimum
                // integer value
                int taken = Integer.MIN_VALUE;

                // If the weight of the current item is less than or equal to the current
                // capacity (cap),
                // calculate the maximum value when the current item is taken
                if (wt[ind] <= cap)
                    taken = val[ind] + cur[cap - wt[ind]];

                // Store the result in the cur array
                cur[cap] = Math.max(notTaken, taken);
            }
        }

        return cur[W];
    }
}