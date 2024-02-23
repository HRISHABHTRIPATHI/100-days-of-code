//{ Driver Code Starts

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            int edges[][] = new int[E][3];
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }
            ot.println(new Solution().spanningTree(V, E, edges));
        }
        ot.close();
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static class Pair {
        int dest, wt;

        public Pair(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    private static void createAdj(ArrayList<Pair> adj[], int edges[][], int V) {
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];

            adj[src].add(new Pair(dest, wt));
            adj[dest].add(new Pair(src, wt));
        }
    }

    private static void calcDist(ArrayList<Pair>[] adj, int edges[][], int V,
            int[] dist, boolean[] vis) {
        dist[0] = 0;
        for (int i = 0; i < V; i++) {
            int mini = Integer.MAX_VALUE;
            int u = 0;
            for (int j = 0; j < V; j++) {
                if (!vis[j] && mini > dist[j]) {
                    mini = dist[j];
                    u = j;
                }
            }

            vis[u] = true;
            for (Pair p : adj[u]) {
                if (!vis[p.dest] && dist[p.dest] > p.wt) {
                    dist[p.dest] = p.wt;
                }
            }

        }
    }

    static int spanningTree(int V, int E, int edges[][]) {
        ArrayList<Pair>[] adj = new ArrayList[V];
        createAdj(adj, edges, V);

        int[] dist = new int[V];
        boolean[] vis = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        calcDist(adj, edges, V, dist, vis);

        int cost = 0;
        for (int i : dist)
            cost += i;
        return cost;
    }
}