
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
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
    public List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
        int m = s.length();
        int n = t.length();

        int[][] dp = lcs(s, t);

        HashSet<String> set = new HashSet<>();

        allLCS(m, n, dp, s, t, "", set, dp[m][n]);

        List<String> ans = new ArrayList<>(set);

        Collections.sort(ans);

        return ans;
    }

    public void allLCS(int m, int n, int[][] dp, String s, String t, String sub, HashSet<String> set, int len) {

        if (sub.length() == len) {
            set.add(sub);
            return;
        }

        for (int i = m; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    allLCS(i - 1, j - 1, dp, s, t, s.charAt(i - 1) + sub, set, len);
                }
            }
        }
    }

    public int[][] lcs(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp;
    }
}