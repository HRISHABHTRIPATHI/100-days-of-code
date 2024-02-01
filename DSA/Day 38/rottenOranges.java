
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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        // Code here
        Queue<Node> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }
        int time = 0;
        int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int flag = 0;
            int size = q.size();
            while (size > 0) {
                int i = q.peek().first;
                int j = q.peek().second;
                q.remove();
                for (int x = 0; x < 4; x++) {
                    int newi = i + dir[x][0];
                    int newj = j + dir[x][1];
                    if (newi >= 0 && newi < n && newj >= 0 && newj < m) {
                        if (grid[newi][newj] == 1) {
                            grid[newi][newj] = 2;
                            flag++;
                            q.add(new Node(newi, newj));
                        }
                    }
                }
                size--;
            }
            if (flag > 0) {
                time++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

}

class Node {
    int first;
    int second;

    Node(int f, int s) {
        this.first = f;
        this.second = s;
    }
}