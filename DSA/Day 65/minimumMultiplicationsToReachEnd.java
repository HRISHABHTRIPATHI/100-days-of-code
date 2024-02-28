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
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static class Graph {
        private int mod = 100000;

        public class Node {
            private int vertex;
            private int steps;

            public Node(int first, int steps) {
                this.vertex = first;
                this.steps = steps;
            }
        }

        public int dijkstra(int[] arr, int start, int end) {
            if (start == end) {
                return 0;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(start, 0));
            int[] distance = new int[100000];
            Arrays.fill(distance, (int) 1e9);
            distance[start] = 0;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int u = node.vertex;
                int steps = node.steps;
                for (int i = 0; i < arr.length; i++) {
                    int v = (arr[i] * u) % mod;
                    if (steps + 1 < distance[v]) {
                        distance[v] = steps + 1;
                        if (v == end) {
                            return steps + 1;
                        }
                        queue.add(new Node(v, steps + 1));
                    }
                }
            }
            return 0;
        }
    }

    int minimumMultiplications(int[] arr, int start, int end) {
        Graph graph = new Graph();
        return graph.dijkstra(arr, start, end);
    }
}
