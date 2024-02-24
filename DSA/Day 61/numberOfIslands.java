
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
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {

    class triplet {
        char ch;
        int r, c;

        triplet(char ch, int r, int c) {
            this.c = ch;
            this.r = r;
            this.c = c;
        }
    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Queue<triplet> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[r][c];
        int count = 0;

        int dx[] = { -1, 1, 0, 0, -1, 1, -1, 1 };
        int dy[] = { 0, 0, -1, 1, -1, -1, 1, 1 };

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    count++;
                    visited[i][j] = true;
                    q.add(new triplet(grid[i][j], i, j));
                    while (!q.isEmpty()) {
                        triplet curr = q.poll();
                        int r1 = curr.r, c1 = curr.c;
                        for (int k = 0; k < 8; k++) {
                            int x = r1 + dx[k];
                            int y = c1 + dy[k];
                            if (x >= 0 && x < r) {
                                if (y >= 0 && y < c) {
                                    if (visited[x][y] == false && grid[x][y] == '1') {
                                        visited[x][y] = true;
                                        q.add(new triplet(grid[x][y], x, y));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return count;

    }
}