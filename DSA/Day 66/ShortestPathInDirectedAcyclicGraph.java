
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java
class PathValue {
    int index;
    int length;

    PathValue(int index, int length) {
        this.index = index;
        this.length = length;
    }
}

class Solution {

    public int[] shortestPath(int v, int e, int[][] edges) {

        // create Map
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        ArrayList<Integer> a;
        for (int i = 0; i < v; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            a = new ArrayList<>();
            a.add(edges[i][1]);
            a.add(edges[i][2]);
            map.get(edges[i][0]).add(a);
        }

        // let's find the shortest path
        PriorityQueue<PathValue> pq = new PriorityQueue<>(new Comparator<PathValue>() {
            @Override
            public int compare(PathValue a, PathValue b) {
                return a.length - b.length;
            }
        });
        int PathLength[] = new int[1000];
        Arrays.fill(PathLength, Integer.MAX_VALUE);

        pq.add(new PathValue(0, 0));
        PathLength[0] = 0;
        while (!pq.isEmpty()) {
            PathValue val = pq.poll();
            int ind = val.index;
            ArrayList<ArrayList<Integer>> list = map.get(ind);
            for (int i = 0; i < list.size(); i++) {
                if (PathLength[ind] + list.get(i).get(1) < PathLength[list.get(i).get(0)]) {
                    PathLength[list.get(i).get(0)] = PathLength[ind] + list.get(i).get(1);
                    pq.add(new PathValue(list.get(i).get(0), PathLength[list.get(i).get(1)]));
                }
            }
        }
        for (int i = 0; i < v; i++) {
            if (PathLength[i] == Integer.MAX_VALUE) {
                PathLength[i] = -1;
            }
        }
        return PathLength;
    }
}