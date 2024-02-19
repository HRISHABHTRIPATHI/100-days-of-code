
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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Solution {

    private class VertexInfo {
        int val;
        int parent;

        public VertexInfo(int val, int parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && detectCycle(adj, vis, i))
                return true;
        }

        return false;
    }

    private boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int startVal) {
        Queue<VertexInfo> queue = new LinkedList<>();
        queue.offer(new VertexInfo(startVal, -1));
        vis[startVal] = true;

        while (!queue.isEmpty()) {
            VertexInfo vertex = queue.poll();

            for (int neighbor : adj.get(vertex.val)) {
                if (neighbor == vertex.parent)
                    continue;

                if (vis[neighbor])
                    return true;

                queue.offer(new VertexInfo(neighbor, vertex.val));
                vis[neighbor] = true;
            }
        }

        return false;
    }
}