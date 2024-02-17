//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        List<Integer> ans = new ArrayList<Integer>();
        if (N == 1 && K == 1) {
            ans.add(A[0] + B[0]);
            return ans;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);

        for (int i = N - 1; i >= 0; i--) {
            pq.offer(new int[] { A[N - 1] + B[i], N - 1, i });
        }

        while (K-- > 0) {
            int[] cur = pq.poll();
            ans.add(cur[0]);
            if (cur[1] > 0) {
                pq.offer(new int[] { A[cur[1] - 1] + B[cur[2]], cur[1] - 1, cur[2] });
            }

        }
        return ans;
    }
}
