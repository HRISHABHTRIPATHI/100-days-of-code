//{ Driver Code Starts
// Initial Template for Java

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
            List<Integer> res = obj.LargestSubset(N, arr);
            int isValidSeq = 1, sz = res.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    if ((res.get(i) % res.get(j) == 0) ||
                            (res.get(j) % res.get(i) == 0))
                        continue;
                    else {
                        isValidSeq = 0;
                        break;
                    }
                }
            }
            System.out.println(isValidSeq + " " + sz);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public List<Integer> LargestSubset(int N, int[] arr) {
        // Code here
        Arrays.sort(arr); // Important part int dp[] = new int[N];
        int hash[] = new int[N];
        int max = 0;
        int lastInd = 0;
        int dp[] = new int[N];

        for (int i = 1; i < N; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {

                if (arr[i] % arr[prev] == 0 && dp[i] < 1 + dp[prev]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                lastInd = i;
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        ans.add(arr[lastInd]);

        while (hash[lastInd] != lastInd) {
            lastInd = hash[lastInd];
            ans.add(arr[lastInd]);
        }

        return ans;
    }
}
