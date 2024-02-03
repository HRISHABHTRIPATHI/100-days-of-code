
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String S) {
        String words = "";
        String ans = "";

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '.') {
                words += S.charAt(i);

            }

            if (S.charAt(i) == '.') {
                words = S.charAt(i) + "" + words;
                ans = words + "" + ans;
                words = "";
            }
            if (i == S.length() - 1) {
                ans = words + "" + ans;
            }

        }
        return ans;
    }
}