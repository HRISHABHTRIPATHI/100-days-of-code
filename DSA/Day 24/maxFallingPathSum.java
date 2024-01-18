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
            int Matrix[][] = new int[N][N];
            for (int i = 0; i < N * N; i++)
                Matrix[(i / N)][i % N] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    static int maxSum(int row, int col, int Matrix[][], int dp[][]) {

        int n = Matrix.length;

        if (col < 0 || col >= n)
            return (int) (-1e9 + 7);

        if (row == 0)
            return Matrix[0][col];

        if (dp[row][col] != -1)
            return dp[row][col];

        int up = Matrix[row][col] + maxSum(row - 1, col, Matrix, dp);
        int left = Matrix[row][col] + maxSum(row - 1, col - 1, Matrix, dp);
        int right = Matrix[row][col] + maxSum(row - 1, col + 1, Matrix, dp);

        return dp[row][col] = Math.max(up, Math.max(left, right));
    }

    static int maximumPath(int N, int Matrix[][]) {
        // code here
        int dp[][] = new int[N][N];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int sum = maxSum(N - 1, i, Matrix, dp);
            max = Math.max(sum, max);
        }
        return max;
    }
}