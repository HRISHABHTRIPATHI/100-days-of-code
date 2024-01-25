//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int N, int arr[]) {
        // Code here
        int[] len = new int[N];
        int[] ele = new int[N];
        for (int i = 0; i < N; i++) {
            len[i] = 1;
            ele[i] = -1;
        }
        int max = 1;
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && len[i] <= len[j] + 1) {
                    len[i] = len[j] + 1;
                    max = Math.max(max, len[i]);
                    ele[i] = j;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            if (len[i] == max) {
                ans.add(arr[i]);
                int idx = ele[i];
                while (idx >= 0) {
                    ans.add(arr[idx]);
                    idx = ele[idx];
                }
                break;
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
