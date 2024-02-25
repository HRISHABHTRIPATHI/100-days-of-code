
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
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Solution {
    public class triplet {
        int r;
        int c;
        int step;

        triplet(int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }

    public int[][] nearest(int[][] grid) {

        int r = grid.length; // rows
        int c = grid[0].length; // columns

        int ans[][] = new int[r][c];
        boolean visited[][] = new boolean[r][c];
        Queue<triplet> q = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    q.add(new triplet(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            triplet temp = q.poll();
            int x = temp.r, y = temp.c, s = temp.step;
            ans[x][y] = s;
            int r1 = x - 1, r2 = x + 1;
            int c1 = y - 1, c2 = y + 1;
            if (r1 >= 0 && r1 < r) {
                if (visited[r1][y] == false) {
                    q.add(new triplet(r1, y, s + 1));
                    visited[r1][y] = true;
                }
            }
            if (r2 >= 0 && r2 < r) {
                if (visited[r2][y] == false) {
                    q.add(new triplet(r2, y, s + 1));
                    visited[r2][y] = true;
                }
            }
            if (c1 >= 0 && c1 < c) {
                if (visited[x][c1] == false) {
                    q.add(new triplet(x, c1, s + 1));
                    visited[x][c1] = true;
                }
            }
            if (c2 >= 0 && c2 < c) {
                if (visited[x][c2] == false) {
                    q.add(new triplet(x, c2, s + 1));
                    visited[x][c2] = true;
                }
            }
        }

        return ans;
    }
}