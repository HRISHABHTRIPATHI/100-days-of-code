//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    int findMinInsertions(String S) {
        // code here
        int n = S.length();

        int len = longestPalinSubseq(S);

        return n - len;
    }

    public int longestPalinSubseq(String X) {
        String Y = rev(X);

        int N = X.length();
        int M = Y.length();

        int[] dp = new int[M + 1];
        int[] temp = new int[M + 1];

        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= M; m++) {

                if (X.charAt(n - 1) == Y.charAt(m - 1))
                    temp[m] = 1 + dp[m - 1];

                else
                    temp[m] = Math.max(dp[m], temp[m - 1]);
            }
            dp = temp.clone();
        }
        return dp[M];
    }

    public String rev(String S) {

        String ans = "";
        int l = S.length();
        for (int i = l - 1; i >= 0; i--) {
            ans += S.charAt(i);
        }
        return ans;
    }
}