//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0, m, n);
            dfs(grid, i, n - 1, m, n);
        }

        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i, m, n);
            dfs(grid, m - 1, i, m, n);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }
        return count;
    }

    void dfs(int[][] grid, int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != 1)
            return;
        grid[r][c] = 0;
        dfs(grid, r + 1, c, m, n);
        dfs(grid, r - 1, c, m, n);
        dfs(grid, r, c + 1, m, n);
        dfs(grid, r, c - 1, m, n);
    }
}