
//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

/*
 * edges: vector of vectors which represents the graph
 * S: source vertex to start traversing graph with
 * V: number of vertices
 */
class Solution {
    static int[] bellman_ford(int v, ArrayList<ArrayList<Integer>> edges, int s) {

        // create Graph
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        for (int i = 0; i < v; i++) {
            map.put(i, new ArrayList<>());
        }
        ArrayList<Integer> a;
        for (int i = 0; i < edges.size(); i++) {
            a = new ArrayList<>();
            a.add(edges.get(i).get(1));
            a.add(edges.get(i).get(2));
            map.get(edges.get(i).get(0)).add(a);
        }

        // Start Implementing Bellman Ford Algorithm
        Queue<Integer> q = new LinkedList<>();
        int pathLength[] = new int[v];

        int negArr[] = new int[v];// check all node . if any node coming grater then number of vertices then there
                                  // is a cycle.
        boolean containNeg = false;

        Arrays.fill(pathLength, 100000000);
        q.add(s);// add source into queue;
        pathLength[s] = 0;

        while (!q.isEmpty()) {
            int val = q.poll();
            if (val == s) {
                negArr[val]++;
            }
            if (negArr[val] > v) {// contain cycle
                containNeg = true;
                break;
            }

            ArrayList<ArrayList<Integer>> list = map.get(val);
            for (ArrayList<Integer> it : list) {
                if (it.get(1) != 0) {
                    if (pathLength[it.get(0)] > pathLength[val] + it.get(1)) {
                        pathLength[it.get(0)] = pathLength[val] + it.get(1);
                        if (!q.contains(it.get(0))) {
                            q.add(it.get(0));
                            negArr[it.get(0)]++;
                        }
                    }
                }
            }
        }

        if (containNeg) {
            return new int[] { -1 };// according to GFG question . if negative path then return -1;
        }

        return pathLength;
    }
}
