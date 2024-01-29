//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] mat = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.countSquares(N, M, mat);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public int countSquares(int N, int M, int mat[][]) {
        // Code here
        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (i > 0 && j > 0 && mat[i][j] == 1) {

                    mat[i][j] = 1 + Math.min(mat[i - 1][j],
                            Math.min(mat[i - 1][j - 1], mat[i][j - 1]));

                }
                ans += mat[i][j];
            }
        }
        return ans;
    }
}