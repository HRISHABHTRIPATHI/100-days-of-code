//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.atoi(str);

            System.out.println(num);
            t--;
        }
    }
}
// } Driver Code Ends

// User function template for JAVA

/* You are required to complete this method */
class Solution {
    int atoi(String s) {
        // Your code here
        if (s == null || s.isEmpty()) {
            return -1; // Empty string, conversion not feasible
        }
        int sign = 1;
        int index = 0;

        // Remove leading whitespaces
        while (index < s.length() && Character.isWhitespace(s.charAt(index))) {
            index++;
        }

        // Check for the sign
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        long result = 0;

        // Convert the remaining characters to integer
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + Character.getNumericValue(s.charAt(index));

            // Check for overflow
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        // Check for non-numeric characters after the first character
        while (index < s.length()) {
            if (!Character.isDigit(s.charAt(index))) {
                return -1;
            }
            index++;
        }

        return (int) (result * sign);
    }
}
