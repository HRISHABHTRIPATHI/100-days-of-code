
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            int src = sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge, n, m, src);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {

        // create Adjacency List
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        // create BFS for shortest path
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        parent[src] = 0;
        q.add(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            int val = q.poll();
            for (int i = 0; i < map.get(val).size(); i++) {
                int curr = map.get(val).get(i);
                if (!visited[curr]) {
                    q.add(curr);
                    visited[curr] = true;
                    parent[curr] = parent[val] + 1;
                }
            }
        }
        return parent;

    }
}