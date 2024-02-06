//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.lookandsay(n));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static String lookandsay(int n) {
        // your code here
        if (n == 1)
            return "1";

        String res = lookandsay(n - 1);

        String s = say(res);

        return s;
    }

    public static String say(String res) {
        StringBuilder res1 = new StringBuilder();
        int count = 1;
        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i) == res.charAt(i - 1))
                count++;
            else {
                res1.append(count).append(res.charAt(i - 1));
                count = 1;
            }

        }
        res1.append(count).append(res.charAt(res.length() - 1));
        return res1.toString();
    }
}
