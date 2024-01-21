
//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends

class Solution {
    int wildCard(String pat, String str) {
        int N = pat.length();
        int M = str.length();

        boolean dp[][] = new boolean[N + 1][M + 1];

        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (pat.charAt(j) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= M; m++) {

                if (pat.charAt(n - 1) == str.charAt(m - 1) || pat.charAt(n - 1) == '?') {
                    dp[n][m] = dp[n - 1][m - 1];

                }

                else if (pat.charAt(n - 1) == '*') {
                    dp[n][m] = dp[n - 1][m] || dp[n][m - 1];
                }

                else {
                    dp[n][m] = false;
                    ;
                }
            }
        }

        return dp[N][M] == true ? 1 : 0;
    }
}
