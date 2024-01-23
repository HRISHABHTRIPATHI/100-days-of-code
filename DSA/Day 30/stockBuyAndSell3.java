
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine().trim());

            int[] price = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends

class Solution {
    public static int maxProfit(int n, int[] price) {
        // code here
        int curr[] = new int[5];
        int next[] = new int[5];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int trans = 3; trans >= 0; trans--) {
                int profit = 0;
                // buy
                if (trans % 2 == 0) {
                    profit = Math.max(-price[ind] + next[trans + 1], next[trans]);
                } // sell
                else {
                    profit = Math.max(price[ind] + next[trans + 1], next[trans]);
                }
                curr[trans] = profit;
            }
            next = curr;
        }
        return curr[0];
    }
}
