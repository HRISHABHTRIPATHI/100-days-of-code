//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    static String longestPalin(String S) {
        // code here
        int n = S.length();
        int[][] dp = new int[n][n];
        int maxLength = 0;
        String ans = "";

        for (int diff = 0; diff < n; diff++) {
            for (int i = 0, j = i + diff; j < n; i++, j++) {
                if (diff == 0) {
                    dp[i][j] = 1;
                } else if (diff == 1) {
                    dp[i][j] = (S.charAt(i) == S.charAt(j)) ? 2 : 0;
                } else {
                    if (S.charAt(i) == S.charAt(j) && dp[i + 1][j - 1] > 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = 0;
                    }
                }

                if (dp[i][j] > 0) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        ans = S.substring(i, j + 1); // Corrected: use substring instead of substr
                    }
                }
            }
        }
        return ans;
    }
}