//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);

            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    ArrayList<Integer> search(String pattern, String text) {
        int textLen = text.length();
        int patternLen = pattern.length();
        int patternHash = hash(pattern, patternLen);
        int textHash = hash(text, patternLen);
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i <= textLen - patternLen; i++) {
            if (patternHash == textHash && checkEquality(text, i, pattern)) {
                al.add(i + 1);
            }
            if (i < textLen - patternLen) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLen));
            }
        }
        if (al.isEmpty()) {
            al.add(-1);
            return al;
        }
        return al;
    }

    // calculate initial hash
    private static int hash(String str, int length) {
        int hashValue = 0;
        for (int i = 0; i < length; i++) {
            hashValue = hashValue + str.charAt(i);
        }
        return hashValue;
    }

    // To implement rooling hash.
    private static int updateHash(int OH, char oldc, char newc) {
        int hashValue = 0;
        hashValue = (OH - oldc) + newc;
        return hashValue;
    }

    private static boolean checkEquality(String str1, int start, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(start + i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}