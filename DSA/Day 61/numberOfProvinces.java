
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj, V));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {

    static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int visited[]) {
        visited[node] = 1;
        ArrayList<Integer> temp = adjLs.get(node);
        for (int eachNode : temp) {
            if (visited[eachNode] != 1) {
                dfs(eachNode, adjLs, visited);
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < V; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    temp.add(j);
                }
            }
            adjLs.add(temp);
        }

        int count = 0;
        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] != 1) {
                count++;
                dfs(i, adjLs, visited);
            }
        }

        return count;
    }

};