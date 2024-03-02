//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Tuple {
    int dis, r, c;

    Tuple(int dis, int r, int c) {
        this.dis = dis;
        this.r = r;
        this.c = c;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if (source[0] == destination[0] && source[1] == destination[1])
            return 0;
        int n = grid.length, m = grid[0].length;
        int dis[][] = new int[n][m];
        for (int[] a : dis)
            Arrays.fill(a, Integer.MAX_VALUE);
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, source[0], source[1]));
        int[] dr = { 0, 1, -1, 0 }, dc = { 1, 0, 0, -1 };
        dis[source[0]][source[1]] = 0;
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            for (int i = 0; i < 4; i++) {
                int cr = t.r + dr[i], cc = t.c + dc[i];
                if (cr >= 0 && cr < n && cc >= 0 && cc < m && grid[cr][cc] == 1 && t.dis + 1 < dis[cr][cc]) {
                    dis[cr][cc] = t.dis + 1;
                    if (cr == destination[0] && cc == destination[1])
                        return dis[cr][cc];
                    q.add(new Tuple(dis[cr][cc], cr, cc));
                }
            }
        }
        return -1;
    }
}
