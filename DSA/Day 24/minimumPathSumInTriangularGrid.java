//{ Driver Code Starts
//Initial Template for Java

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
            ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int j = 0; j <= i; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer>> grid) {
        // Code here
        if (n == 1)
            return grid.get(0).get(0);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                int min = Math.min(grid.get(i + 1).get(j), grid.get(i + 1).get(j + 1));
                grid.get(i).set(j, grid.get(i).get(j) + min);
            }
        }
        return grid.get(0).get(0);
    }
}