
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int p = sc.nextInt(); // Take size of both the strings as input
            int q = sc.nextInt();

            String s1 = sc.next(); // Take both the string as input
            String s2 = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.lcs(p, q, s1, s2));
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int n, int m, String s1, String s2) {
        // your code here
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved
        // yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with zeros since LCS with an empty
        // string is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using dynamic programming
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS
                // length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                // If the characters are different, choose the maximum LCS length by either
                // excluding a character in s1 or excluding a character in s2
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }

}