
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// class Solution
// {
// //Function to return the minimum cost to react at bottom
// //right cell from top left cell.
// public int minimumCostPath(int[][] matrix)
// {
// // Code here
// int n = matrix.length;
// int m = matrix[0].length;
// int dp[][] = new int[n][m];

// // Iterate through the matrix
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (i == 0 && j == 0)
// dp[i][j] = matrix[i][j]; // If we're at the top-left cell, the minimum sum is
// its value
// else {
// int up = matrix[i][j];
// if (i > 0)
// up += dp[i - 1][j]; // Add the value from above if it's not out of bounds
// else
// up += (int) Math.pow(10, 9); // Add a large value if out of bounds in the up
// direction
// int left = matrix[i][j];
// if (j > 0)
// left += dp[i][j - 1]; // Add the value from the left if it's not out of
// bounds
// else
// left += (int) Math.pow(10, 9); // Add a large value if out of bounds in the
// left direction
// // Store the minimum of the two possible paths
// dp[i][j] = Math.min(up, left);
// }
// }
// }
// // The final result is stored in the bottom-right cell of the DP matrix
// return dp[n - 1][m - 1];
// }
// }

class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    // Function to return the minimum cost to react at bottom
    // right cell from top left cell.
    public boolean isSafe(int[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
            return false;
        return true;
    }

    public int minimumCostPath(int[][] grid) {
        // Code here
        int n = grid.length, m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.dist - b.dist));

        pq.add(new Pair(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int currow = curr.row;
            int currcol = curr.col;
            int currdist = curr.dist;

            for (int i = 0; i < 4; i++) {
                int newr = currow + dr[i];
                int newc = currcol + dc[i];

                if (isSafe(grid, newr, newc)) {
                    if (grid[newr][newc] + currdist < dist[newr][newc]) {
                        dist[newr][newc] = grid[newr][newc] + currdist;
                        pq.add(new Pair(newr, newc, dist[newr][newc]));
                    }
                }
            }

        }
        return dist[n - 1][m - 1];
    }
}