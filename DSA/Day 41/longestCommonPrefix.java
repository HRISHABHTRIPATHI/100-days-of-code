//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            int[] ans = obj.longestCommonPrefix(s1, s2);
            if (ans[0] == -1)
                System.out.println(ans[0]);
            else
                System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public int[] longestCommonPrefix(String s1, String s2) {
        int arr[] = { -1, -1 };
        for (int i = s1.length() - 1; i > 0; i--) {
            if (s2.contains(s1.substring(0, i))) {
                arr[0] = 0;
                arr[1] = i - 1;
                return arr;
            }
        }
        return arr;
    }
}