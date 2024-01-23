//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    static int maxProfit(int k, int n, int prices[]) {
        // code here
        int[][] ahead = new int[2][k + 1];
        int[][] cur = new int[2][k + 1];

        // Iterate through the array backwards
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 0) { // We can buy the stock
                        cur[buy][cap] = Math.max(0 + ahead[0][cap],
                                -prices[ind] + ahead[1][cap]);
                    } else { // We can sell the stock
                        cur[buy][cap] = Math.max(0 + ahead[1][cap],
                                prices[ind] + ahead[0][cap - 1]);
                    }
                }
            }
            // Update the 'ahead' array with the values from 'cur'
            for (int i = 0; i < 2; i++) {
                System.arraycopy(cur[i], 0, ahead[i], 0, k + 1);
            }
        }

        return ahead[0][k];
    }
}